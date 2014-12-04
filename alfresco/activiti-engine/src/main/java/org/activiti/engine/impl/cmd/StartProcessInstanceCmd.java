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
package org.activiti.engine.impl.cmd;

import java.io.Serializable;
import java.util.Map;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.deploy.DeploymentCache;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.ProcessInstance;


// TODO: Auto-generated Javadoc
/**
 * The Class StartProcessInstanceCmd.
 *
 * @param <T> the generic type
 * @author Tom Baeyens
 */
public class StartProcessInstanceCmd<T> implements Command<ProcessInstance>, Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;
  
  /** The process definition key. */
  protected String processDefinitionKey;
  
  /** The process definition id. */
  protected String processDefinitionId;
  
  /** The variables. */
  protected Map<String, Object> variables;
  
  /** The business key. */
  protected String businessKey;
  
  /**
   * Instantiates a new start process instance cmd.
   *
   * @param processDefinitionKey the process definition key
   * @param processDefinitionId the process definition id
   * @param businessKey the business key
   * @param variables the variables
   */
  public StartProcessInstanceCmd(String processDefinitionKey, String processDefinitionId, String businessKey, Map<String, Object> variables) {
    this.processDefinitionKey = processDefinitionKey;
    this.processDefinitionId = processDefinitionId;
    this.businessKey = businessKey;
    this.variables = variables;
  }
  
  /* (non-Javadoc)
   * @see org.activiti.engine.impl.interceptor.Command#execute(org.activiti.engine.impl.interceptor.CommandContext)
   */
  public ProcessInstance execute(CommandContext commandContext) {
    DeploymentCache deploymentCache = Context
      .getProcessEngineConfiguration()
      .getDeploymentCache();
    
    ProcessDefinitionEntity processDefinition = null;
    if (processDefinitionId!=null) {
      processDefinition = deploymentCache.findDeployedProcessDefinitionById(processDefinitionId);
      if (processDefinition == null) {
        throw new ActivitiException("No process definition found for id = '" + processDefinitionId + "'");
      }
    } else if(processDefinitionKey != null){
      processDefinition = deploymentCache.findDeployedLatestProcessDefinitionByKey(processDefinitionKey);
      if (processDefinition == null) {
        throw new ActivitiException("No process definition found for key '" + processDefinitionKey +"'");
      }
    } else {
      throw new ActivitiException("processDefinitionKey and processDefinitionId are null");
    }
    
    ExecutionEntity processInstance = processDefinition.createProcessInstance(businessKey);

    if (variables!=null) {
      processInstance.setVariables(variables);
    }
    
    processInstance.start();
    
    return processInstance;
  }
}