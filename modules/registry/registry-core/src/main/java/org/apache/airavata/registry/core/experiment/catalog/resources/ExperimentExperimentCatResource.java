/*
*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*
*/
package org.apache.airavata.registry.core.experiment.catalog.resources;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.airavata.registry.core.experiment.catalog.ExpCatResourceUtils;
import org.apache.airavata.registry.core.experiment.catalog.ExperimentCatResource;
import org.apache.airavata.registry.core.experiment.catalog.ResourceType;
import org.apache.airavata.registry.core.experiment.catalog.model.*;
import org.apache.airavata.registry.core.experiment.catalog.utils.QueryGenerator;
import org.apache.airavata.registry.cpi.RegistryException;
import org.apache.airavata.registry.cpi.utils.StatusType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExperimentExperimentCatResource extends AbstractExperimentCatResource {
    private static final Logger logger = LoggerFactory.getLogger(ExperimentExperimentCatResource.class);
//    private WorkerResource worker;
    private String executionUser;
    private String expID;
    private Timestamp creationTime;
    private String gatewayId;
    private String projectId;
    private String expName;
    private String description;
    private String applicationId;
    private String applicationVersion;
    private String workflowTemplateId;
    private String workflowTemplateVersion;
    private String workflowExecutionId;
    private boolean enableEmailNotifications;
    private String gatewayExecutionId;
    private List<ExperimentInputExperimentCatResource> experimentInputResources;
    private List<ExperimentOutputExperimentCatResource> experimentOutputputResources;
    private ComputationSchedulingExperimentCatResource computationSchedulingResource;
    private ConfigDataExperimentCatResource userConfigDataResource;
    private List<WorkflowNodeDetailExperimentCatResource> workflowNodeDetailResourceList;
    private List<StatusExperimentCatResource> stateChangeList;
    private List<ErrorDetailExperimentCatResource> errorDetailList;
    private StatusExperimentCatResource experimentStatus;
    private List<NotificationEmailExperimentCatResource> emailResourceList;

    /**
     *
     * @return  experiment ID
     */
    public String getExpID() {
        return expID;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getWorkflowTemplateId() {
        return workflowTemplateId;
    }

    public void setWorkflowTemplateId(String workflowTemplateId) {
        this.workflowTemplateId = workflowTemplateId;
    }

    public String getWorkflowTemplateVersion() {
        return workflowTemplateVersion;
    }

    public void setWorkflowTemplateVersion(String workflowTemplateVersion) {
        this.workflowTemplateVersion = workflowTemplateVersion;
    }

    public String getWorkflowExecutionId() {
        return workflowExecutionId;
    }

    public void setWorkflowExecutionId(String workflowExecutionId) {
        this.workflowExecutionId = workflowExecutionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnableEmailNotifications() {
        return enableEmailNotifications;
    }

    public void setEnableEmailNotifications(boolean enableEmailNotifications) {
        this.enableEmailNotifications = enableEmailNotifications;
    }

    public String getGatewayExecutionId() {
        return gatewayExecutionId;
    }

    public void setGatewayExecutionId(String gatewayExecutionId) {
        this.gatewayExecutionId = gatewayExecutionId;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<ExperimentInputExperimentCatResource> getExperimentInputResources() {
        return experimentInputResources;
    }

    public void setExperimentInputResources(List<ExperimentInputExperimentCatResource> experimentInputResources) {
        this.experimentInputResources = experimentInputResources;
    }

    public List<ExperimentOutputExperimentCatResource> getExperimentOutputputResources() {
        return experimentOutputputResources;
    }

    public void setExperimentOutputputResources(List<ExperimentOutputExperimentCatResource> experimentOutputputResources) {
        this.experimentOutputputResources = experimentOutputputResources;
    }

    public ComputationSchedulingExperimentCatResource getComputationSchedulingResource() {
        return computationSchedulingResource;
    }

    public void setComputationSchedulingResource(ComputationSchedulingExperimentCatResource computationSchedulingResource) {
        this.computationSchedulingResource = computationSchedulingResource;
    }

    public ConfigDataExperimentCatResource getUserConfigDataResource() {
        return userConfigDataResource;
    }

    public void setUserConfigDataResource(ConfigDataExperimentCatResource userConfigDataResource) {
        this.userConfigDataResource = userConfigDataResource;
    }

    public List<WorkflowNodeDetailExperimentCatResource> getWorkflowNodeDetailResourceList() {
        return workflowNodeDetailResourceList;
    }

    public void setWorkflowNodeDetailResourceList(List<WorkflowNodeDetailExperimentCatResource> workflowNodeDetailResourceList) {
        this.workflowNodeDetailResourceList = workflowNodeDetailResourceList;
    }

    public List<StatusExperimentCatResource> getStateChangeList() {
        return stateChangeList;
    }

    public void setStateChangeList(List<StatusExperimentCatResource> stateChangeList) {
        this.stateChangeList = stateChangeList;
    }

    public List<ErrorDetailExperimentCatResource> getErrorDetailList() {
        return errorDetailList;
    }

    public void setErrorDetailList(List<ErrorDetailExperimentCatResource> errorDetailList) {
        this.errorDetailList = errorDetailList;
    }

    public void setExperimentStatus(StatusExperimentCatResource experimentStatus) {
        this.experimentStatus = experimentStatus;
    }

    public List<NotificationEmailExperimentCatResource> getEmailResourceList() {
        return emailResourceList;
    }

    public void setEmailResourceList(List<NotificationEmailExperimentCatResource> emailResourceList) {
        this.emailResourceList = emailResourceList;
    }


    /**
     * Since experiments are at the leaf level, this method is not
     * valid for an experiment
     * @param type  child resource types
     * @return UnsupportedOperationException
     */
    public ExperimentCatResource create(ResourceType type) throws RegistryException {
    	switch (type){
	        case EXPERIMENT_INPUT:
	        	ExperimentInputExperimentCatResource inputResource = new ExperimentInputExperimentCatResource();
	            inputResource.setExperimentId(expID);
	            return inputResource;
            case EXPERIMENT_OUTPUT:
                ExperimentOutputExperimentCatResource experimentOutputResource = new ExperimentOutputExperimentCatResource();
                experimentOutputResource.setExperimentId(expID);
                return experimentOutputResource;
            case NOTIFICATION_EMAIL:
                NotificationEmailExperimentCatResource emailResource = new NotificationEmailExperimentCatResource();
                emailResource.setExperimentId(expID);
                return emailResource;
            case WORKFLOW_NODE_DETAIL:
                WorkflowNodeDetailExperimentCatResource nodeDetailResource = new WorkflowNodeDetailExperimentCatResource();
                nodeDetailResource.setExperimentId(expID);
                return nodeDetailResource;
            case ERROR_DETAIL:
                ErrorDetailExperimentCatResource errorDetailResource = new ErrorDetailExperimentCatResource();
                errorDetailResource.setExperimentId(expID);
                return errorDetailResource;
            case STATUS:
                StatusExperimentCatResource statusResource = new StatusExperimentCatResource();
                statusResource.setExperimentId(expID);
                return statusResource;
            case CONFIG_DATA:
                ConfigDataExperimentCatResource configDataResource = new ConfigDataExperimentCatResource();
                configDataResource.setExperimentId(expID);
                return configDataResource;
            case COMPUTATIONAL_RESOURCE_SCHEDULING:
                ComputationSchedulingExperimentCatResource schedulingResource = new ComputationSchedulingExperimentCatResource();
                schedulingResource.setExperimentId(expID);
                return schedulingResource;
            case ADVANCE_INPUT_DATA_HANDLING:
                AdvanceInputDataHandlingExperimentCatResource dataHandlingResource = new AdvanceInputDataHandlingExperimentCatResource();
                dataHandlingResource.setExperimentId(expID);
                return dataHandlingResource;
            case ADVANCE_OUTPUT_DATA_HANDLING:
                AdvancedOutputDataHandlingExperimentCatResource outputDataHandlingResource = new AdvancedOutputDataHandlingExperimentCatResource();
                outputDataHandlingResource.setExperimentId(expID);
                return outputDataHandlingResource;
            case QOS_PARAM:
                QosParamExperimentCatResource qosParamResource = new QosParamExperimentCatResource();
                qosParamResource.setExperimentId(expID);
                return qosParamResource;
	        default:
                logger.error("Unsupported resource type for experiment resource.", new IllegalArgumentException());
	            throw new IllegalArgumentException("Unsupported resource type for experiment resource.");
	    }
    }

    /**
     *
     * @param type  child resource types
     * @param name name of the child resource
     * @return UnsupportedOperationException
     */
    public void remove(ResourceType type, Object name) throws RegistryException {
        EntityManager em = null;
        try {
            em = ExpCatResourceUtils.getEntityManager();
            em.getTransaction().begin();
            Query q;
            QueryGenerator generator;
            switch (type) {
                case EXPERIMENT_INPUT:
                    generator = new QueryGenerator(EXPERIMENT_INPUT);
                    generator.setParameter(ExperimentInputConstants.EXPERIMENT_ID, name);
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                case EXPERIMENT_OUTPUT:
                    generator = new QueryGenerator(EXPERIMENT_OUTPUT);
                    generator.setParameter(ExperimentOutputConstants.EXPERIMENT_ID, name);
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                case NOTIFICATION_EMAIL:
                    generator = new QueryGenerator(NOTIFICATION_EMAIL);
                    generator.setParameter(NotificationEmailConstants.EXPERIMENT_ID, name);
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                case WORKFLOW_NODE_DETAIL:
                    generator = new QueryGenerator(WORKFLOW_NODE_DETAIL);
                    generator.setParameter(WorkflowNodeDetailsConstants.NODE_INSTANCE_ID, name);
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                case ERROR_DETAIL:
                    generator = new QueryGenerator(ERROR_DETAIL);
                    generator.setParameter(ErrorDetailConstants.EXPERIMENT_ID, name);
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                case STATUS:
                    generator = new QueryGenerator(STATUS);
                    generator.setParameter(StatusConstants.EXPERIMENT_ID, name);
                    generator.setParameter(StatusConstants.STATUS_TYPE, StatusType.EXPERIMENT.toString());
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                case CONFIG_DATA:
                    generator = new QueryGenerator(CONFIG_DATA);
                    generator.setParameter(ExperimentConfigurationDataConstants.EXPERIMENT_ID, name);
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                case COMPUTATIONAL_RESOURCE_SCHEDULING:
                    generator = new QueryGenerator(COMPUTATIONAL_RESOURCE_SCHEDULING);
                    generator.setParameter(ComputationalResourceSchedulingConstants.EXPERIMENT_ID, name);
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                case ADVANCE_INPUT_DATA_HANDLING:
                    generator = new QueryGenerator(ADVANCE_INPUT_DATA_HANDLING);
                    generator.setParameter(AdvancedInputDataHandlingConstants.EXPERIMENT_ID, name);
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                case ADVANCE_OUTPUT_DATA_HANDLING:
                    generator = new QueryGenerator(ADVANCE_OUTPUT_DATA_HANDLING);
                    generator.setParameter(AdvancedOutputDataHandlingConstants.EXPERIMENT_ID, name);
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                case QOS_PARAM:
                    generator = new QueryGenerator(QOS_PARAMS);
                    generator.setParameter(QosParamsConstants.EXPERIMENT_ID, name);
                    q = generator.deleteQuery(em);
                    q.executeUpdate();
                    break;
                default:
                    logger.error("Unsupported resource type for experiment resource.", new IllegalArgumentException());
                    break;
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RegistryException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()){
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
    }

    /**
     *
     * @param type  child resource types
     * @param name name of the child resource
     * @return UnsupportedOperationException
     */
    public ExperimentCatResource get(ResourceType type, Object name) throws RegistryException {
        EntityManager em = null;
        try {
            em = ExpCatResourceUtils.getEntityManager();
            em.getTransaction().begin();
            QueryGenerator generator;
            Query q;
            switch (type) {
                case EXPERIMENT_INPUT:
                    generator = new QueryGenerator(EXPERIMENT_INPUT);
                    generator.setParameter(ExperimentInputConstants.EXPERIMENT_ID, name);
                    q = generator.selectQuery(em);
                    Experiment_Input experimentInput = (Experiment_Input) q.getSingleResult();
                    ExperimentInputExperimentCatResource inputResource = (ExperimentInputExperimentCatResource) Utils.getResource(ResourceType.EXPERIMENT_INPUT, experimentInput);
                    em.getTransaction().commit();
                    em.close();
                    return inputResource;
                case EXPERIMENT_OUTPUT:
                    generator = new QueryGenerator(EXPERIMENT_OUTPUT);
                    generator.setParameter(ExperimentOutputConstants.EXPERIMENT_ID, name);
                    q = generator.selectQuery(em);
                    Experiment_Output experimentOutput = (Experiment_Output) q.getSingleResult();
                    ExperimentOutputExperimentCatResource outputResource = (ExperimentOutputExperimentCatResource) Utils.getResource(ResourceType.EXPERIMENT_OUTPUT, experimentOutput);
                    em.getTransaction().commit();
                    em.close();
                    return outputResource;
                case NOTIFICATION_EMAIL:
                    generator = new QueryGenerator(NOTIFICATION_EMAIL);
                    generator.setParameter(NotificationEmailConstants.EXPERIMENT_ID, name);
                    q = generator.selectQuery(em);
                    Notification_Email notificationEmail = (Notification_Email) q.getSingleResult();
                    NotificationEmailExperimentCatResource notificationEmailResource = (NotificationEmailExperimentCatResource) Utils.getResource(ResourceType.NOTIFICATION_EMAIL, notificationEmail);
                    em.getTransaction().commit();
                    em.close();
                    return notificationEmailResource;
                case WORKFLOW_NODE_DETAIL:
                    generator = new QueryGenerator(WORKFLOW_NODE_DETAIL);
                    generator.setParameter(WorkflowNodeDetailsConstants.NODE_INSTANCE_ID, name);
                    q = generator.selectQuery(em);
                    WorkflowNodeDetail workflowNodeDetail = (WorkflowNodeDetail) q.getSingleResult();
                    WorkflowNodeDetailExperimentCatResource nodeDetailResource = (WorkflowNodeDetailExperimentCatResource) Utils.getResource(ResourceType.WORKFLOW_NODE_DETAIL, workflowNodeDetail);
                    em.getTransaction().commit();
                    em.close();
                    return nodeDetailResource;
                case ERROR_DETAIL:
                    generator = new QueryGenerator(ERROR_DETAIL);
                    generator.setParameter(ErrorDetailConstants.EXPERIMENT_ID, name);
                    q = generator.selectQuery(em);
                    ErrorDetail errorDetail = (ErrorDetail) q.getSingleResult();
                    ErrorDetailExperimentCatResource errorDetailResource = (ErrorDetailExperimentCatResource) Utils.getResource(ResourceType.ERROR_DETAIL, errorDetail);
                    em.getTransaction().commit();
                    em.close();
                    return errorDetailResource;
                case STATUS:
                    generator = new QueryGenerator(STATUS);
                    generator.setParameter(StatusConstants.EXPERIMENT_ID, name);
                    generator.setParameter(StatusConstants.STATUS_TYPE, StatusType.EXPERIMENT.toString());
                    q = generator.selectQuery(em);
                    Status status = (Status) q.getSingleResult();
                    StatusExperimentCatResource statusResource = (StatusExperimentCatResource) Utils.getResource(ResourceType.STATUS, status);
                    em.getTransaction().commit();
                    em.close();
                    return statusResource;
                case CONFIG_DATA:
                    generator = new QueryGenerator(CONFIG_DATA);
                    generator.setParameter(ExperimentConfigurationDataConstants.EXPERIMENT_ID, name);
                    q = generator.selectQuery(em);
                    ExperimentConfigData configData = (ExperimentConfigData) q.getSingleResult();
                    ConfigDataExperimentCatResource configDataResource = (ConfigDataExperimentCatResource) Utils.getResource(ResourceType.CONFIG_DATA, configData);
                    em.getTransaction().commit();
                    em.close();
                    return configDataResource;
                case COMPUTATIONAL_RESOURCE_SCHEDULING:
                    generator = new QueryGenerator(COMPUTATIONAL_RESOURCE_SCHEDULING);
                    generator.setParameter(ComputationalResourceSchedulingConstants.EXPERIMENT_ID, name);
                    generator.setParameter(ComputationalResourceSchedulingConstants.TASK_ID, null);
                    q = generator.selectQuery(em);
                    Computational_Resource_Scheduling scheduling = (Computational_Resource_Scheduling) q.getSingleResult();
                    ComputationSchedulingExperimentCatResource schedulingResource = (ComputationSchedulingExperimentCatResource) Utils.getResource(ResourceType.COMPUTATIONAL_RESOURCE_SCHEDULING, scheduling);
                    em.getTransaction().commit();
                    em.close();
                    return schedulingResource;
                case ADVANCE_INPUT_DATA_HANDLING:
                    generator = new QueryGenerator(ADVANCE_INPUT_DATA_HANDLING);
                    generator.setParameter(AdvancedInputDataHandlingConstants.EXPERIMENT_ID, name);
                    generator.setParameter(AdvancedInputDataHandlingConstants.TASK_ID, null);
                    q = generator.selectQuery(em);
                    AdvancedInputDataHandling inputDataHandling = (AdvancedInputDataHandling) q.getSingleResult();
                    AdvanceInputDataHandlingExperimentCatResource dataHandlingResource = (AdvanceInputDataHandlingExperimentCatResource) Utils.getResource(ResourceType.ADVANCE_INPUT_DATA_HANDLING, inputDataHandling);
                    em.getTransaction().commit();
                    em.close();
                    return dataHandlingResource;
                case ADVANCE_OUTPUT_DATA_HANDLING:
                    generator = new QueryGenerator(ADVANCE_OUTPUT_DATA_HANDLING);
                    generator.setParameter(AdvancedOutputDataHandlingConstants.EXPERIMENT_ID, name);
                    generator.setParameter(AdvancedOutputDataHandlingConstants.TASK_ID, null);
                    q = generator.selectQuery(em);
                    AdvancedOutputDataHandling outputDataHandling = (AdvancedOutputDataHandling) q.getSingleResult();
                    AdvancedOutputDataHandlingExperimentCatResource outputDataHandlingResource = (AdvancedOutputDataHandlingExperimentCatResource) Utils.getResource(ResourceType.ADVANCE_OUTPUT_DATA_HANDLING, outputDataHandling);
                    em.getTransaction().commit();
                    em.close();
                    return outputDataHandlingResource;
                case QOS_PARAM:
                    generator = new QueryGenerator(QOS_PARAMS);
                    generator.setParameter(QosParamsConstants.EXPERIMENT_ID, name);
                    generator.setParameter(QosParamsConstants.TASK_ID, null);
                    q = generator.selectQuery(em);
                    QosParam qosParam = (QosParam) q.getSingleResult();
                    QosParamExperimentCatResource qosParamResource = (QosParamExperimentCatResource) Utils.getResource(ResourceType.QOS_PARAM, qosParam);
                    em.getTransaction().commit();
                    em.close();
                    return qosParamResource;
                default:
                    em.getTransaction().commit();
                    em.close();
                    logger.error("Unsupported resource type for experiment resource.", new IllegalArgumentException());
                    throw new IllegalArgumentException("Unsupported resource type for experiment data resource.");
            }
        } catch (Exception e) {
            throw new RegistryException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()){
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }

    }

    /**
     *
     * @param type  child resource types
     * @return UnsupportedOperationException
     */
    public List<ExperimentCatResource> get(ResourceType type)  throws RegistryException{
        List<ExperimentCatResource> resourceList = new ArrayList<ExperimentCatResource>();
        EntityManager em = null;
        try {
            em = ExpCatResourceUtils.getEntityManager();
            em.getTransaction().begin();
            Query q;
            QueryGenerator generator;
            List results;
            switch (type) {
                case EXPERIMENT_INPUT:
                    generator = new QueryGenerator(EXPERIMENT_INPUT);
                    generator.setParameter(ExperimentInputConstants.EXPERIMENT_ID, expID);
                    q = generator.selectQuery(em);
                    results = q.getResultList();
                    if (results.size() != 0) {
                        for (Object result : results) {
                            Experiment_Input exInput = (Experiment_Input) result;
                            ExperimentInputExperimentCatResource inputResource =
                                    (ExperimentInputExperimentCatResource) Utils.getResource(ResourceType.EXPERIMENT_INPUT, exInput);
                            resourceList.add(inputResource);
                        }
                    }
                    break;
                case EXPERIMENT_OUTPUT:
                    generator = new QueryGenerator(EXPERIMENT_OUTPUT);
                    generator.setParameter(ExperimentOutputConstants.EXPERIMENT_ID, expID);
                    q = generator.selectQuery(em);
                    results = q.getResultList();
                    if (results.size() != 0) {
                        for (Object result : results) {
                            Experiment_Output output = (Experiment_Output) result;
                            ExperimentOutputExperimentCatResource outputResource =
                                    (ExperimentOutputExperimentCatResource) Utils.getResource(ResourceType.EXPERIMENT_OUTPUT, output);
                            resourceList.add(outputResource);
                        }
                    }
                    break;
                case NOTIFICATION_EMAIL:
                    generator = new QueryGenerator(NOTIFICATION_EMAIL);
                    generator.setParameter(NotificationEmailConstants.EXPERIMENT_ID, expID);
                    q = generator.selectQuery(em);
                    results = q.getResultList();
                    if (results.size() != 0) {
                        for (Object result : results) {
                            Notification_Email notificationEmail = (Notification_Email) result;
                            NotificationEmailExperimentCatResource emailResource =
                                    (NotificationEmailExperimentCatResource) Utils.getResource(ResourceType.NOTIFICATION_EMAIL, notificationEmail);
                            resourceList.add(emailResource);
                        }
                    }
                    break;
                case WORKFLOW_NODE_DETAIL:
                    generator = new QueryGenerator(WORKFLOW_NODE_DETAIL);
                    generator.setParameter(WorkflowNodeDetailsConstants.EXPERIMENT_ID, expID);
                    q = generator.selectQuery(em);
                    results = q.getResultList();
                    if (results.size() != 0) {
                        for (Object result : results) {
                            WorkflowNodeDetail nodeDetail = (WorkflowNodeDetail) result;
                            WorkflowNodeDetailExperimentCatResource nodeDetailResource =
                                    (WorkflowNodeDetailExperimentCatResource) Utils.getResource(ResourceType.WORKFLOW_NODE_DETAIL, nodeDetail);
                            resourceList.add(nodeDetailResource);
                        }
                    }
                    break;
                case ERROR_DETAIL:
                    generator = new QueryGenerator(ERROR_DETAIL);
                    generator.setParameter(ErrorDetailConstants.EXPERIMENT_ID, expID);
                    q = generator.selectQuery(em);
                    results = q.getResultList();
                    if (results.size() != 0) {
                        for (Object result : results) {
                            ErrorDetail errorDetail = (ErrorDetail) result;
                            ErrorDetailExperimentCatResource errorDetailResource =
                                    (ErrorDetailExperimentCatResource) Utils.getResource(ResourceType.ERROR_DETAIL, errorDetail);
                            resourceList.add(errorDetailResource);
                        }
                    }
                    break;
                case STATUS:
                    generator = new QueryGenerator(STATUS);
                    generator.setParameter(StatusConstants.EXPERIMENT_ID, expID);
                    q = generator.selectQuery(em);
                    results = q.getResultList();
                    if (results.size() != 0) {
                        for (Object result : results) {
                            Status status = (Status) result;
                            StatusExperimentCatResource statusResource =
                                    (StatusExperimentCatResource) Utils.getResource(ResourceType.STATUS, status);
                            resourceList.add(statusResource);
                        }
                    }
                    break;
                default:
                    em.getTransaction().commit();
                    em.close();
                    logger.error("Unsupported resource type for experiment resource.", new UnsupportedOperationException());
                    throw new UnsupportedOperationException();
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RegistryException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()){
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        return resourceList;
    }

    /**
     * save experiment
     */
    public void save() throws RegistryException{
        EntityManager em = null;
        try {
            em = ExpCatResourceUtils.getEntityManager();
            Experiment existingExp = em.find(Experiment.class, expID);
            em.close();

            em = ExpCatResourceUtils.getEntityManager();
            em.getTransaction().begin();
            Experiment experiment = new Experiment();
            experiment.setProjectID(projectId);
            experiment.setExpId(expID);
            experiment.setExecutionUser(executionUser);
            experiment.setExecutionUser(executionUser);
            experiment.setGatewayId(gatewayId);
            experiment.setCreationTime(creationTime);
            experiment.setExpName(expName);
            experiment.setExpDesc(description);
            experiment.setApplicationId(applicationId);
            experiment.setAppVersion(applicationVersion);
            experiment.setWorkflowExecutionId(workflowExecutionId);
            experiment.setWorkflowTemplateVersion(workflowTemplateVersion);
            experiment.setWorkflowExecutionId(workflowExecutionId);
            experiment.setAllowNotification(enableEmailNotifications);
            experiment.setGatewayExecutionId(gatewayExecutionId);
            if (existingExp != null) {
                existingExp.setGatewayId(gatewayId);
                existingExp.setExecutionUser(executionUser);
                existingExp.setProjectID(projectId);
                existingExp.setCreationTime(creationTime);
                existingExp.setExpName(expName);
                existingExp.setExpDesc(description);
                existingExp.setApplicationId(applicationId);
                existingExp.setAppVersion(applicationVersion);
                existingExp.setWorkflowExecutionId(workflowExecutionId);
                existingExp.setWorkflowTemplateVersion(workflowTemplateVersion);
                existingExp.setWorkflowExecutionId(workflowExecutionId);
                existingExp.setAllowNotification(enableEmailNotifications);
                existingExp.setGatewayExecutionId(gatewayExecutionId);
                experiment = em.merge(existingExp);
            } else {
                em.persist(experiment);
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RegistryException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()){
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
    }

    /**
     *
     * @param expID experiment ID
     */
    public void setExpID(String expID) {
		this.expID = expID;
	}

    public String getExecutionUser() {
        return executionUser;
    }

    public void setExecutionUser(String executionUser) {
        this.executionUser = executionUser;
    }

    public List<NotificationEmailExperimentCatResource> getNotificationEmails () throws RegistryException{
        List<NotificationEmailExperimentCatResource> emailResources = new ArrayList<NotificationEmailExperimentCatResource>();
        List<ExperimentCatResource> resources = get(ResourceType.NOTIFICATION_EMAIL);
        for (ExperimentCatResource resource : resources) {
            emailResources.add((NotificationEmailExperimentCatResource) resource);
        }
        return emailResources;
    }

    public List<ExperimentInputExperimentCatResource> getExperimentInputs () throws RegistryException{
        List<ExperimentInputExperimentCatResource> expInputs = new ArrayList<ExperimentInputExperimentCatResource>();
        List<ExperimentCatResource> resources = get(ResourceType.EXPERIMENT_INPUT);
        for (ExperimentCatResource resource : resources) {
            expInputs.add((ExperimentInputExperimentCatResource) resource);
        }
        return expInputs;
    }

    public List<ExperimentOutputExperimentCatResource> getExperimentOutputs () throws RegistryException{
        List<ExperimentOutputExperimentCatResource> expOutputs = new ArrayList<ExperimentOutputExperimentCatResource>();
        List<ExperimentCatResource> resources = get(ResourceType.EXPERIMENT_OUTPUT);
        for (ExperimentCatResource resource : resources) {
            expOutputs.add((ExperimentOutputExperimentCatResource) resource);
        }
        return expOutputs;
    }

    public StatusExperimentCatResource getExperimentStatus() throws RegistryException{
        List<ExperimentCatResource> resources = get(ResourceType.STATUS);
        for (ExperimentCatResource resource : resources) {
            StatusExperimentCatResource expStatus = (StatusExperimentCatResource) resource;
            if(expStatus.getStatusType().equals(StatusType.EXPERIMENT.toString())){
                if (expStatus.getState() == null || expStatus.getState().equals("") ){
                    expStatus.setState("UNKNOWN");
                }
                return expStatus;
            }
        }
        return null;
    }

    public List<StatusExperimentCatResource> getWorkflowNodeStatuses() throws RegistryException{
        List<StatusExperimentCatResource> statuses = new ArrayList<StatusExperimentCatResource>();
        List<ExperimentCatResource> resources = get(ResourceType.STATUS);
        for (ExperimentCatResource resource : resources) {
            StatusExperimentCatResource workflowNodeStatus = (StatusExperimentCatResource) resource;
            if(workflowNodeStatus.getStatusType().equals(StatusType.WORKFLOW_NODE.toString())){
                if (workflowNodeStatus.getState() == null || workflowNodeStatus.getState().equals("")){
                    workflowNodeStatus.setState("UNKNOWN");
                }
                statuses.add(workflowNodeStatus);
            }
        }
        return statuses;
    }

    public List<WorkflowNodeDetailExperimentCatResource> getWorkflowNodeDetails () throws RegistryException{
        List<WorkflowNodeDetailExperimentCatResource> workflowNodeDetailResourceList = new ArrayList<WorkflowNodeDetailExperimentCatResource>();
        List<ExperimentCatResource> resources = get(ResourceType.WORKFLOW_NODE_DETAIL);
        for (ExperimentCatResource resource : resources) {
            WorkflowNodeDetailExperimentCatResource nodeDetailResource = (WorkflowNodeDetailExperimentCatResource) resource;
            workflowNodeDetailResourceList.add(nodeDetailResource);
        }
        return workflowNodeDetailResourceList;
    }

    public List<ErrorDetailExperimentCatResource> getErrorDetails () throws RegistryException{
        List<ErrorDetailExperimentCatResource> errorDetailResources = new ArrayList<ErrorDetailExperimentCatResource>();
        List<ExperimentCatResource> resources = get(ResourceType.ERROR_DETAIL);
        for (ExperimentCatResource resource : resources) {
            ErrorDetailExperimentCatResource errorDetailResource = (ErrorDetailExperimentCatResource) resource;
            errorDetailResources.add(errorDetailResource);
        }
        return errorDetailResources;
    }

    public ComputationSchedulingExperimentCatResource getComputationScheduling (String expId) throws RegistryException{
        return  (ComputationSchedulingExperimentCatResource)get(ResourceType.COMPUTATIONAL_RESOURCE_SCHEDULING, expId);
    }

    public AdvanceInputDataHandlingExperimentCatResource getInputDataHandling (String expId) throws RegistryException{
        return  (AdvanceInputDataHandlingExperimentCatResource)get(ResourceType.ADVANCE_INPUT_DATA_HANDLING, expId);
    }

    public AdvancedOutputDataHandlingExperimentCatResource getOutputDataHandling (String expId) throws RegistryException{
        return  (AdvancedOutputDataHandlingExperimentCatResource)get(ResourceType.ADVANCE_OUTPUT_DATA_HANDLING, expId);
    }

    public QosParamExperimentCatResource getQOSparams (String expId) throws RegistryException{
        return  (QosParamExperimentCatResource)get(ResourceType.QOS_PARAM, expId);
    }

    public ConfigDataExperimentCatResource getUserConfigData(String expID) throws RegistryException{
        return (ConfigDataExperimentCatResource)get(ResourceType.CONFIG_DATA, expID);
    }
    public WorkflowNodeDetailExperimentCatResource getWorkflowNode (String nodeId) throws RegistryException{
        return (WorkflowNodeDetailExperimentCatResource)get(ResourceType.WORKFLOW_NODE_DETAIL, nodeId);
    }
}
