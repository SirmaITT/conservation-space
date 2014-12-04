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

package org.activiti.engine.impl;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.query.QueryProperty;
import org.activiti.engine.runtime.JobQuery;

// TODO: Auto-generated Javadoc
/**
 * Contains the possible properties that can be used in a {@link JobQuery}.
 * 
 * @author Joram Barrez
 */
public class JobQueryProperty implements QueryProperty {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The Constant properties. */
  private static final Map<String, JobQueryProperty> properties = new HashMap<String, JobQueryProperty>();

  /** The Constant JOB_ID. */
  public static final JobQueryProperty JOB_ID = new JobQueryProperty("ID_");
  
  /** The Constant PROCESS_INSTANCE_ID. */
  public static final JobQueryProperty PROCESS_INSTANCE_ID = new JobQueryProperty("J.PROCESS_INSTANCE_ID_");
  
  /** The Constant EXECUTION_ID. */
  public static final JobQueryProperty EXECUTION_ID = new JobQueryProperty("J.EXECUTION_ID_");
  
  /** The Constant DUEDATE. */
  public static final JobQueryProperty DUEDATE = new JobQueryProperty("J.DUEDATE_");
  
  /** The Constant RETRIES. */
  public static final JobQueryProperty RETRIES = new JobQueryProperty("J.RETRIES_");

  /** The name. */
  private String name;

  /**
   * Instantiates a new job query property.
   *
   * @param name the name
   */
  public JobQueryProperty(String name) {
    this.name = name;
    properties.put(name, this);
  }

  /* (non-Javadoc)
   * @see org.activiti.engine.query.QueryProperty#getName()
   */
  public String getName() {
    return name;
  }
  
  /**
   * Find by name.
   *
   * @param propertyName the property name
   * @return the job query property
   */
  public static JobQueryProperty findByName(String propertyName) {
    return properties.get(propertyName);
  }

}