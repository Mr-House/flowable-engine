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
package org.flowable.cmmn.model;

/**
 * @author Joram Barrez
 */
public class TextAnnotation extends CmmnElement {

    protected String text;
    protected String textFormat;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextFormat() {
        return textFormat;
    }

    public void setTextFormat(String textFormat) {
        this.textFormat = textFormat;
    }

    @Override
    public TextAnnotation clone() {
        TextAnnotation clone = new TextAnnotation();
        clone.setValues(this);
        return clone;
    }

    public void setValues(TextAnnotation otherElement) {
        super.setValues(otherElement);
        setText(otherElement.getText());
        setTextFormat(otherElement.getTextFormat());
    }
}
