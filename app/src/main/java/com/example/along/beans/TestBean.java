package com.example.along.beans;

/**
 * Title:
 * <p>
 * Description:
 * </p>
 * Author dragon.
 * Date 2018/4/16 16:17
 */

public class TestBean {

    /**
     * data : {"backlogParam":{"unfinished":0,"finish":0,"backlogs":null},"managingPersonCount":1731,"patientPersonCount":11,"servicesRemindCount":13,"monitoringWarningCount":13,"followUpCount":6}
     * status : 0
     * msg : SUCCESS
     * timestamp : 1523866116849
     */

    private DataBean data;
    private int status;
    private String msg;
    private long timestamp;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class DataBean {
        /**
         * backlogParam : {"unfinished":0,"finish":0,"backlogs":null}
         * managingPersonCount : 1731
         * patientPersonCount : 11
         * servicesRemindCount : 13
         * monitoringWarningCount : 13
         * followUpCount : 6
         */

        private BacklogParamBean backlogParam;
        private int managingPersonCount;
        private int patientPersonCount;
        private int servicesRemindCount;
        private int monitoringWarningCount;
        private int followUpCount;

        public BacklogParamBean getBacklogParam() {
            return backlogParam;
        }

        public void setBacklogParam(BacklogParamBean backlogParam) {
            this.backlogParam = backlogParam;
        }

        public int getManagingPersonCount() {
            return managingPersonCount;
        }

        public void setManagingPersonCount(int managingPersonCount) {
            this.managingPersonCount = managingPersonCount;
        }

        public int getPatientPersonCount() {
            return patientPersonCount;
        }

        public void setPatientPersonCount(int patientPersonCount) {
            this.patientPersonCount = patientPersonCount;
        }

        public int getServicesRemindCount() {
            return servicesRemindCount;
        }

        public void setServicesRemindCount(int servicesRemindCount) {
            this.servicesRemindCount = servicesRemindCount;
        }

        public int getMonitoringWarningCount() {
            return monitoringWarningCount;
        }

        public void setMonitoringWarningCount(int monitoringWarningCount) {
            this.monitoringWarningCount = monitoringWarningCount;
        }

        public int getFollowUpCount() {
            return followUpCount;
        }

        public void setFollowUpCount(int followUpCount) {
            this.followUpCount = followUpCount;
        }

        public static class BacklogParamBean {
            /**
             * unfinished : 0
             * finish : 0
             * backlogs : null
             */

            private int unfinished;
            private int finish;
            private Object backlogs;

            public int getUnfinished() {
                return unfinished;
            }

            public void setUnfinished(int unfinished) {
                this.unfinished = unfinished;
            }

            public int getFinish() {
                return finish;
            }

            public void setFinish(int finish) {
                this.finish = finish;
            }

            public Object getBacklogs() {
                return backlogs;
            }

            public void setBacklogs(Object backlogs) {
                this.backlogs = backlogs;
            }
        }
    }
}
