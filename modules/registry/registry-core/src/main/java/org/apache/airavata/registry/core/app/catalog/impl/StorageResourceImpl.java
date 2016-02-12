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

package org.apache.airavata.registry.core.app.catalog.impl;

import org.apache.airavata.model.appcatalog.storageresource.StorageResourceDescription;
import org.apache.airavata.model.commons.airavata_commonsConstants;
import org.apache.airavata.model.data.movement.DataMovementInterface;
import org.apache.airavata.registry.core.app.catalog.resources.AppCatAbstractResource;
import org.apache.airavata.registry.core.app.catalog.resources.AppCatalogResource;
import org.apache.airavata.registry.core.app.catalog.resources.StorageInterfaceResource;
import org.apache.airavata.registry.core.app.catalog.resources.StorageResourceResource;
import org.apache.airavata.registry.core.app.catalog.util.AppCatalogThriftConversion;
import org.apache.airavata.registry.core.app.catalog.util.AppCatalogUtils;
import org.apache.airavata.registry.cpi.AppCatalogException;
import org.apache.airavata.registry.cpi.StorageResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageResourceImpl implements StorageResource {
    private final static Logger logger = LoggerFactory.getLogger(StorageResourceImpl.class);


	protected String saveStorageResourceDescriptorData(
			StorageResourceDescription description) throws AppCatalogException {
		//TODO remove existing one
        StorageResourceResource storageResourceResource = saveStorageResource(description);
		return storageResourceResource.getStorageResourceId();
	}

	protected StorageResourceResource saveStorageResource(
			StorageResourceDescription description) throws AppCatalogException {
        StorageResourceResource storageResourceResource = AppCatalogThriftConversion.getStorageResource(description);
        storageResourceResource.save();
        saveDataMovementInterfaces(description, storageResourceResource);
		return storageResourceResource;
	}

    protected void saveDataMovementInterfaces(
            StorageResourceDescription description,
            StorageResourceResource storageResourceResource)
            throws AppCatalogException {
        List<DataMovementInterface> dataMovemenetInterfaces = description.getDataMovementInterfaces();
        if (dataMovemenetInterfaces != null && !dataMovemenetInterfaces.isEmpty()) {
            for (DataMovementInterface dataMovementInterface : dataMovemenetInterfaces) {
                StorageInterfaceResource storageInterface = AppCatalogThriftConversion.getStorageInterface(dataMovementInterface);
                storageInterface.setStorageResourceResource(storageResourceResource);
                storageInterface.setStorageResourceId(storageResourceResource.getStorageResourceId());
                storageInterface.save();
            }
        }
    }
    /**
     * This function will add a storage resource description to the database
     *
     * @param description storage resource description
     * @return unique resource ID generated by airavata
     */
    @Override
    public String addStorageResource(StorageResourceDescription description) throws AppCatalogException {
        try {
            if (description.getStorageResourceDescription().equals("") || description.getStorageResourceId().equals(airavata_commonsConstants.DEFAULT_ID)){
                description.setStorageResourceId(AppCatalogUtils.getID(description.getHostName()));
            }
            return saveStorageResourceDescriptorData(description);
        } catch (Exception e) {
            logger.error("Error while saving storage resource...", e);
            throw new AppCatalogException(e);
        }
    }

    /**
     * This method will update storage resource
     *
     * @param storageResourceId      unique storage resource id
     * @param updatedStorageResource updated storage resource
     */
    @Override
    public void updateStorageResource(String storageResourceId, StorageResourceDescription updatedStorageResource) throws AppCatalogException {
        try {
            saveStorageResourceDescriptorData(updatedStorageResource);
        } catch (Exception e) {
            logger.error("Error while updating storage resource...", e);
            throw new AppCatalogException(e);
        }
    }

    /**
     * This method will retrieve storage resource object on given resource id
     *
     * @param resourceId unique resource id
     * @return StorageResource object
     */
    @Override
    public StorageResourceDescription getStorageResource(String resourceId) throws AppCatalogException {
        try {
            StorageResourceResource resource = new StorageResourceResource();
            StorageResourceResource storageResource = (StorageResourceResource)resource.get(resourceId);
            return AppCatalogThriftConversion.getStorageDescription(storageResource);
        }catch (Exception e){
            logger.error("Error while retrieving storage resource...", e);
            throw new AppCatalogException(e);
        }
    }

    /**
     * This method will return a list of storageResource descriptions according to given search criteria
     *
     * @param filters map should be provided as the field name and it's value
     * @return list of storage resources
     */
    @Override
    public List<StorageResourceDescription> getStorageResourceList(Map<String, String> filters) throws AppCatalogException {
        List<StorageResourceDescription> storageResourceDescriptions = new ArrayList<StorageResourceDescription>();
        try {
            //TODO check if this is correct way to do this
            StorageResourceResource resource = new StorageResourceResource();
            for (String fieldName : filters.keySet() ){
                if (fieldName.equals(AppCatAbstractResource.StorageResourceConstants.HOST_NAME)){
                    List<AppCatalogResource> resources = resource.get(AppCatAbstractResource.ComputeResourceConstants.HOST_NAME, filters.get(fieldName));
                    if (resources != null && !resources.isEmpty()){
                        storageResourceDescriptions = AppCatalogThriftConversion.getStorageDescriptionList(resources);
                    }
                }else {
                    logger.error("Unsupported field name for storage resource.", new IllegalArgumentException());
                    throw new IllegalArgumentException("Unsupported field name for storage resource.");
                }
            }
        }catch (Exception e){
            logger.error("Error while retrieving storage resource list...", e);
            throw new AppCatalogException(e);
        }
        return storageResourceDescriptions;
    }

    /**
     * This method will retrieve all the storage resources
     *
     * @return list of storage resources
     * @throws AppCatalogException
     */
    @Override
    public List<StorageResourceDescription> getAllStorageResourceList() throws AppCatalogException {
        List<StorageResourceDescription> storageResourceDescriptions = new ArrayList<StorageResourceDescription>();
        try {
            StorageResourceResource resource = new StorageResourceResource();
            List<AppCatalogResource> resources = resource.getAll();
            if (resources != null && !resources.isEmpty()){
                storageResourceDescriptions = AppCatalogThriftConversion.getStorageDescriptionList(resources);
            }
        }catch (Exception e){
            logger.error("Error while retrieving storage resource list...", e);
            throw new AppCatalogException(e);
        }
        return storageResourceDescriptions;
    }

    /**
     * This method will retrieve all the storage resource id with it's name
     *
     * @return map of storage resource ids + name
     * @throws AppCatalogException
     */
    @Override
    public Map<String, String> getAllStorageResourceIdList() throws AppCatalogException {
        try {
            Map<String, String> storageResourceMap = new HashMap<String, String>();
            StorageResourceResource resource = new StorageResourceResource();
            List<AppCatalogResource> allStorageResources = resource.getAll();
            if (allStorageResources != null && !allStorageResources.isEmpty()){
                for (AppCatalogResource sr : allStorageResources){
                    StorageResourceResource srr = (StorageResourceResource)sr;
                    storageResourceMap.put(srr.getStorageResourceId(), srr.getHostName());
                }
            }
            return storageResourceMap;
        }catch (Exception e){
            logger.error("Error while retrieving storage resource list...", e);
            throw new AppCatalogException(e);
        }
    }

    /**
     * This method will retrieve all the enabled storage resource id with it's name
     *
     * @return
     * @throws AppCatalogException
     */
    @Override
    public Map<String, String> getAvailableStorageResourceIdList() throws AppCatalogException {
        try {
            Map<String, String> storageResourceMap = new HashMap<String, String>();
            StorageResourceResource resource = new StorageResourceResource();
            List<AppCatalogResource> allStorageResources = resource.getAll();
            if (allStorageResources != null && !allStorageResources.isEmpty()){
                for (AppCatalogResource sr : allStorageResources){
                    StorageResourceResource srr = (StorageResourceResource)sr;
                    if(srr.isEnabled()) {
                        storageResourceMap.put(srr.getStorageResourceId(), srr.getHostName());
                    }
                }
            }
            return storageResourceMap;
        }catch (Exception e){
            logger.error("Error while retrieving storage resource list...", e);
            throw new AppCatalogException(e);
        }
    }

    /**
     * This method will check whether the given resource already exists in the system
     *
     * @param resourceId unique resource id
     * @return true or false
     */
    @Override
    public boolean isStorageResourceExists(String resourceId) throws AppCatalogException {
        try {
            StorageResourceResource resource = new StorageResourceResource();
            return resource.isExists(resourceId);
        }catch (Exception e){
            logger.error("Error while retrieving storage resource...", e);
            throw new AppCatalogException(e);
        }
    }

    /**
     * This method will remove given resource from the system
     *
     * @param resourceId unique resource id
     */
    @Override
    public void removeStorageResource(String resourceId) throws AppCatalogException {
        try {
            StorageResourceResource resource = new StorageResourceResource();
            resource.remove(resourceId);
        }catch (Exception e){
            logger.error("Error while removing storage resource...", e);
            throw new AppCatalogException(e);
        }
    }

    @Override
    public void removeDataMovementInterface(String storageResourceId, String dataMovementInterfaceId) throws AppCatalogException {
        try {
            StorageInterfaceResource resource = new StorageInterfaceResource();
            Map<String, String> ids = new HashMap<String, String>();
            ids.put(AppCatAbstractResource.StorageInterfaceConstants.STORAGE_RESOURCE_ID, storageResourceId);
            ids.put(AppCatAbstractResource.StorageInterfaceConstants.DATA_MOVEMENT_ID, dataMovementInterfaceId);
            resource.remove(ids);
        }catch (Exception e){
            logger.error("Error while removing data movement interface..", e);
            throw new AppCatalogException(e);
        }
    }
}
