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
package org.activiti.engine.impl.variable;

import java.util.Arrays;

import org.activiti.engine.impl.persistence.entity.VariableInstanceEntity;


// TODO: Auto-generated Javadoc
/**
 * The Class DeserializedObject.
 *
 * @author Tom Baeyens
 */
public class DeserializedObject {

  /** The deserialized object. */
  Object deserializedObject;
  
  /** The original bytes. */
  byte[] originalBytes;
  
  /** The variable instance entity. */
  VariableInstanceEntity variableInstanceEntity;
  
  /**
   * Instantiates a new deserialized object.
   *
   * @param deserializedObject the deserialized object
   * @param serializedBytes the serialized bytes
   * @param variableInstanceEntity the variable instance entity
   */
  public DeserializedObject(Object deserializedObject, byte[] serializedBytes, VariableInstanceEntity variableInstanceEntity) {
    this.deserializedObject = deserializedObject;
    this.originalBytes = serializedBytes;
    this.variableInstanceEntity = variableInstanceEntity;
  }

  /**
   * Flush.
   */
  public void flush() {
    // this first check verifies if the variable value was not overwritten with another object
    if (deserializedObject==variableInstanceEntity.getCachedValue()) {
      byte[] bytes = SerializableType.serialize(deserializedObject, variableInstanceEntity);
      if (!Arrays.equals(originalBytes, bytes)) {
        variableInstanceEntity
          .getByteArrayValue()
          .setBytes(bytes);
      }
    }
  }
}