/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.model.data.resource;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-12-2")
public class ResourceModel implements org.apache.thrift.TBase<ResourceModel, ResourceModel._Fields>, java.io.Serializable, Cloneable, Comparable<ResourceModel> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ResourceModel");

  private static final org.apache.thrift.protocol.TField RESOURCE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("resourceId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField RESOURCE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("resourceName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField REPLICA_LOCATIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("replicaLocations", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ResourceModelStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ResourceModelTupleSchemeFactory());
  }

  private String resourceId; // optional
  private String resourceName; // optional
  private List<ReplicaLocationModel> replicaLocations; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESOURCE_ID((short)1, "resourceId"),
    RESOURCE_NAME((short)2, "resourceName"),
    REPLICA_LOCATIONS((short)3, "replicaLocations");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RESOURCE_ID
          return RESOURCE_ID;
        case 2: // RESOURCE_NAME
          return RESOURCE_NAME;
        case 3: // REPLICA_LOCATIONS
          return REPLICA_LOCATIONS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.RESOURCE_ID,_Fields.RESOURCE_NAME};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESOURCE_ID, new org.apache.thrift.meta_data.FieldMetaData("resourceId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.RESOURCE_NAME, new org.apache.thrift.meta_data.FieldMetaData("resourceName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REPLICA_LOCATIONS, new org.apache.thrift.meta_data.FieldMetaData("replicaLocations", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "ReplicaLocationModel"))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ResourceModel.class, metaDataMap);
  }

  public ResourceModel() {
  }

  public ResourceModel(
    List<ReplicaLocationModel> replicaLocations)
  {
    this();
    this.replicaLocations = replicaLocations;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ResourceModel(ResourceModel other) {
    if (other.isSetResourceId()) {
      this.resourceId = other.resourceId;
    }
    if (other.isSetResourceName()) {
      this.resourceName = other.resourceName;
    }
    if (other.isSetReplicaLocations()) {
      List<ReplicaLocationModel> __this__replicaLocations = new ArrayList<ReplicaLocationModel>(other.replicaLocations.size());
      for (ReplicaLocationModel other_element : other.replicaLocations) {
        __this__replicaLocations.add(other_element);
      }
      this.replicaLocations = __this__replicaLocations;
    }
  }

  public ResourceModel deepCopy() {
    return new ResourceModel(this);
  }

  @Override
  public void clear() {
    this.resourceId = null;
    this.resourceName = null;
    this.replicaLocations = null;
  }

  public String getResourceId() {
    return this.resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public void unsetResourceId() {
    this.resourceId = null;
  }

  /** Returns true if field resourceId is set (has been assigned a value) and false otherwise */
  public boolean isSetResourceId() {
    return this.resourceId != null;
  }

  public void setResourceIdIsSet(boolean value) {
    if (!value) {
      this.resourceId = null;
    }
  }

  public String getResourceName() {
    return this.resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public void unsetResourceName() {
    this.resourceName = null;
  }

  /** Returns true if field resourceName is set (has been assigned a value) and false otherwise */
  public boolean isSetResourceName() {
    return this.resourceName != null;
  }

  public void setResourceNameIsSet(boolean value) {
    if (!value) {
      this.resourceName = null;
    }
  }

  public int getReplicaLocationsSize() {
    return (this.replicaLocations == null) ? 0 : this.replicaLocations.size();
  }

  public java.util.Iterator<ReplicaLocationModel> getReplicaLocationsIterator() {
    return (this.replicaLocations == null) ? null : this.replicaLocations.iterator();
  }

  public void addToReplicaLocations(ReplicaLocationModel elem) {
    if (this.replicaLocations == null) {
      this.replicaLocations = new ArrayList<ReplicaLocationModel>();
    }
    this.replicaLocations.add(elem);
  }

  public List<ReplicaLocationModel> getReplicaLocations() {
    return this.replicaLocations;
  }

  public void setReplicaLocations(List<ReplicaLocationModel> replicaLocations) {
    this.replicaLocations = replicaLocations;
  }

  public void unsetReplicaLocations() {
    this.replicaLocations = null;
  }

  /** Returns true if field replicaLocations is set (has been assigned a value) and false otherwise */
  public boolean isSetReplicaLocations() {
    return this.replicaLocations != null;
  }

  public void setReplicaLocationsIsSet(boolean value) {
    if (!value) {
      this.replicaLocations = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESOURCE_ID:
      if (value == null) {
        unsetResourceId();
      } else {
        setResourceId((String)value);
      }
      break;

    case RESOURCE_NAME:
      if (value == null) {
        unsetResourceName();
      } else {
        setResourceName((String)value);
      }
      break;

    case REPLICA_LOCATIONS:
      if (value == null) {
        unsetReplicaLocations();
      } else {
        setReplicaLocations((List<ReplicaLocationModel>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESOURCE_ID:
      return getResourceId();

    case RESOURCE_NAME:
      return getResourceName();

    case REPLICA_LOCATIONS:
      return getReplicaLocations();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESOURCE_ID:
      return isSetResourceId();
    case RESOURCE_NAME:
      return isSetResourceName();
    case REPLICA_LOCATIONS:
      return isSetReplicaLocations();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ResourceModel)
      return this.equals((ResourceModel)that);
    return false;
  }

  public boolean equals(ResourceModel that) {
    if (that == null)
      return false;

    boolean this_present_resourceId = true && this.isSetResourceId();
    boolean that_present_resourceId = true && that.isSetResourceId();
    if (this_present_resourceId || that_present_resourceId) {
      if (!(this_present_resourceId && that_present_resourceId))
        return false;
      if (!this.resourceId.equals(that.resourceId))
        return false;
    }

    boolean this_present_resourceName = true && this.isSetResourceName();
    boolean that_present_resourceName = true && that.isSetResourceName();
    if (this_present_resourceName || that_present_resourceName) {
      if (!(this_present_resourceName && that_present_resourceName))
        return false;
      if (!this.resourceName.equals(that.resourceName))
        return false;
    }

    boolean this_present_replicaLocations = true && this.isSetReplicaLocations();
    boolean that_present_replicaLocations = true && that.isSetReplicaLocations();
    if (this_present_replicaLocations || that_present_replicaLocations) {
      if (!(this_present_replicaLocations && that_present_replicaLocations))
        return false;
      if (!this.replicaLocations.equals(that.replicaLocations))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_resourceId = true && (isSetResourceId());
    list.add(present_resourceId);
    if (present_resourceId)
      list.add(resourceId);

    boolean present_resourceName = true && (isSetResourceName());
    list.add(present_resourceName);
    if (present_resourceName)
      list.add(resourceName);

    boolean present_replicaLocations = true && (isSetReplicaLocations());
    list.add(present_replicaLocations);
    if (present_replicaLocations)
      list.add(replicaLocations);

    return list.hashCode();
  }

  @Override
  public int compareTo(ResourceModel other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResourceId()).compareTo(other.isSetResourceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResourceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.resourceId, other.resourceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetResourceName()).compareTo(other.isSetResourceName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResourceName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.resourceName, other.resourceName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetReplicaLocations()).compareTo(other.isSetReplicaLocations());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReplicaLocations()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.replicaLocations, other.replicaLocations);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ResourceModel(");
    boolean first = true;

    if (isSetResourceId()) {
      sb.append("resourceId:");
      if (this.resourceId == null) {
        sb.append("null");
      } else {
        sb.append(this.resourceId);
      }
      first = false;
    }
    if (isSetResourceName()) {
      if (!first) sb.append(", ");
      sb.append("resourceName:");
      if (this.resourceName == null) {
        sb.append("null");
      } else {
        sb.append(this.resourceName);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("replicaLocations:");
    if (this.replicaLocations == null) {
      sb.append("null");
    } else {
      sb.append(this.replicaLocations);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ResourceModelStandardSchemeFactory implements SchemeFactory {
    public ResourceModelStandardScheme getScheme() {
      return new ResourceModelStandardScheme();
    }
  }

  private static class ResourceModelStandardScheme extends StandardScheme<ResourceModel> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ResourceModel struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RESOURCE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.resourceId = iprot.readString();
              struct.setResourceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RESOURCE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.resourceName = iprot.readString();
              struct.setResourceNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // REPLICA_LOCATIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.replicaLocations = new ArrayList<ReplicaLocationModel>(_list0.size);
                ReplicaLocationModel _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new ReplicaLocationModel();
                  _elem1.read(iprot);
                  struct.replicaLocations.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setReplicaLocationsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ResourceModel struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.resourceId != null) {
        if (struct.isSetResourceId()) {
          oprot.writeFieldBegin(RESOURCE_ID_FIELD_DESC);
          oprot.writeString(struct.resourceId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.resourceName != null) {
        if (struct.isSetResourceName()) {
          oprot.writeFieldBegin(RESOURCE_NAME_FIELD_DESC);
          oprot.writeString(struct.resourceName);
          oprot.writeFieldEnd();
        }
      }
      if (struct.replicaLocations != null) {
        oprot.writeFieldBegin(REPLICA_LOCATIONS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.replicaLocations.size()));
          for (ReplicaLocationModel _iter3 : struct.replicaLocations)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ResourceModelTupleSchemeFactory implements SchemeFactory {
    public ResourceModelTupleScheme getScheme() {
      return new ResourceModelTupleScheme();
    }
  }

  private static class ResourceModelTupleScheme extends TupleScheme<ResourceModel> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ResourceModel struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResourceId()) {
        optionals.set(0);
      }
      if (struct.isSetResourceName()) {
        optionals.set(1);
      }
      if (struct.isSetReplicaLocations()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetResourceId()) {
        oprot.writeString(struct.resourceId);
      }
      if (struct.isSetResourceName()) {
        oprot.writeString(struct.resourceName);
      }
      if (struct.isSetReplicaLocations()) {
        {
          oprot.writeI32(struct.replicaLocations.size());
          for (ReplicaLocationModel _iter4 : struct.replicaLocations)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ResourceModel struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.resourceId = iprot.readString();
        struct.setResourceIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.resourceName = iprot.readString();
        struct.setResourceNameIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.replicaLocations = new ArrayList<ReplicaLocationModel>(_list5.size);
          ReplicaLocationModel _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new ReplicaLocationModel();
            _elem6.read(iprot);
            struct.replicaLocations.add(_elem6);
          }
        }
        struct.setReplicaLocationsIsSet(true);
      }
    }
  }

}
