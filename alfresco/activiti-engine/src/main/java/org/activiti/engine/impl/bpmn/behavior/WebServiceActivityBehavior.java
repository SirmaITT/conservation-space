/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.engine.impl.bpmn.behavior;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.bpmn.data.AbstractDataAssociation;
import org.activiti.engine.impl.bpmn.data.IOSpecification;
import org.activiti.engine.impl.bpmn.data.ItemInstance;
import org.activiti.engine.impl.bpmn.webservice.MessageInstance;
import org.activiti.engine.impl.bpmn.webservice.Operation;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;

// TODO: Auto-generated Javadoc
/**
 * An activity behavior that allows calling Web services.
 *
 * @author Esteban Robles Luna
 * @author Falko Menge
 * @author Joram Barrez
 */
public class WebServiceActivityBehavior extends AbstractBpmnActivityBehavior {
  
  /** The Constant CURRENT_MESSAGE. */
  public static final String CURRENT_MESSAGE = "org.activiti.engine.impl.bpmn.CURRENT_MESSAGE";

  /** The operation. */
  protected Operation operation;
  
  /** The io specification. */
  protected IOSpecification ioSpecification;
  
  /** The data input associations. */
  protected List<AbstractDataAssociation> dataInputAssociations;

  /** The data output associations. */
  protected List<AbstractDataAssociation> dataOutputAssociations;

  /**
   * Instantiates a new web service activity behavior.
   *
   * @param operation the operation
   */
  public WebServiceActivityBehavior(Operation operation) {
    this.operation = operation;
    this.dataInputAssociations = new ArrayList<AbstractDataAssociation>();
    this.dataOutputAssociations = new ArrayList<AbstractDataAssociation>();
  }
  
  /**
   * Adds the data input association.
   *
   * @param dataAssociation the data association
   */
  public void addDataInputAssociation(AbstractDataAssociation dataAssociation) {
    this.dataInputAssociations.add(dataAssociation);
  }
  
  /**
   * Adds the data output association.
   *
   * @param dataAssociation the data association
   */
  public void addDataOutputAssociation(AbstractDataAssociation dataAssociation) {
    this.dataOutputAssociations.add(dataAssociation);
  }
  
  /**
   * {@inheritDoc}
   */
  public void execute(ActivityExecution execution) throws Exception {
    MessageInstance message;
    
    if (ioSpecification != null) {
      this.ioSpecification.initialize(execution);
      ItemInstance inputItem = (ItemInstance) execution.getVariable(this.ioSpecification.getFirstDataInputName());
      message = new MessageInstance(this.operation.getInMessage(), inputItem);
    } else {
      message = this.operation.getInMessage().createInstance();
    }
    
    execution.setVariable(CURRENT_MESSAGE, message);
    
    this.fillMessage(message, execution);
    
    MessageInstance receivedMessage = this.operation.sendMessage(message);

    execution.setVariable(CURRENT_MESSAGE, receivedMessage);

    if (ioSpecification != null) {
      String firstDataOutputName = this.ioSpecification.getFirstDataOutputName();
      if (firstDataOutputName != null) {
        ItemInstance outputItem = (ItemInstance) execution.getVariable(firstDataOutputName);
        outputItem.getStructureInstance().loadFrom(receivedMessage.getStructureInstance().toArray());
      }
    }
    
    this.returnMessage(receivedMessage, execution);
    
    execution.setVariable(CURRENT_MESSAGE, null);
    leave(execution);
  }
  
  /**
   * Return message.
   *
   * @param message the message
   * @param execution the execution
   */
  private void returnMessage(MessageInstance message, ActivityExecution execution) {
    for (AbstractDataAssociation dataAssociation : this.dataOutputAssociations) {
      dataAssociation.evaluate(execution);
    }
  }

  /**
   * Fill message.
   *
   * @param message the message
   * @param execution the execution
   */
  private void fillMessage(MessageInstance message, ActivityExecution execution) {
    for (AbstractDataAssociation dataAssociation : this.dataInputAssociations) {
      dataAssociation.evaluate(execution);
    }
  }

  /**
   * Sets the io specification.
   *
   * @param ioSpecification the new io specification
   */
  public void setIoSpecification(IOSpecification ioSpecification) {
    this.ioSpecification = ioSpecification;
  }
}
