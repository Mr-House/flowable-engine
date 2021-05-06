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
package org.flowable.engine.test.impl.logger;

import org.flowable.common.engine.impl.agenda.AgendaOperationRunner;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.agenda.AbstractOperation;
import org.flowable.engine.impl.interceptor.CommandInvoker;

/**
 * @author jbarrez
 */
public class LoggingCommandInvoker extends CommandInvoker {

    protected ProcessExecutionLogger processExecutionLogger;

    public LoggingCommandInvoker(AgendaOperationRunner agendaOperationRunner, ProcessExecutionLogger processExecutionLogger) {
        super(agendaOperationRunner);
        this.processExecutionLogger = processExecutionLogger;
    }

    @Override
    public void executeOperation(CommandContext commandContext, Runnable runnable) {

        DebugInfoOperationExecuted debugInfo = null;
        if (runnable instanceof AbstractOperation) {

            debugInfo = new DebugInfoOperationExecuted((AbstractOperation) runnable);
            debugInfo.setPreExecutionTime(System.currentTimeMillis());

            processExecutionLogger.addDebugInfo(debugInfo, true);
        }

        super.executeOperation(commandContext, runnable);

        if (debugInfo != null) {
            debugInfo.setPostExecutionTime(System.currentTimeMillis());
        }
    }

}
