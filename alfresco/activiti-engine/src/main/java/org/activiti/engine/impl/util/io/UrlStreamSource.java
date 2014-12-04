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
package org.activiti.engine.impl.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.activiti.engine.ActivitiException;


// TODO: Auto-generated Javadoc
/**
 * The Class UrlStreamSource.
 *
 * @author Tom Baeyens
 */
public class UrlStreamSource implements StreamSource {

  /** The url. */
  URL url;
  
  /**
   * Instantiates a new url stream source.
   *
   * @param url the url
   */
  public UrlStreamSource(URL url) {
    this.url = url;
  }

  /* (non-Javadoc)
   * @see org.activiti.engine.impl.util.io.StreamSource#getInputStream()
   */
  public InputStream getInputStream() {
    try {
      return url.openStream();
    } catch (IOException e) {
      throw new ActivitiException("couldn't open url '"+url+"'", e);
    }
  }
}