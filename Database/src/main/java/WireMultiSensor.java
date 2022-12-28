/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)", date = "2022-07-02")
public class WireMultiSensor implements org.apache.thrift.TBase<WireMultiSensor, WireMultiSensor._Fields>, java.io.Serializable, Cloneable, Comparable<WireMultiSensor> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WireMultiSensor");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TEMPERATURE_FIELD_DESC = new org.apache.thrift.protocol.TField("temperature", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField HUMIDITY_FIELD_DESC = new org.apache.thrift.protocol.TField("humidity", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField BRIGHTNESS_FIELD_DESC = new org.apache.thrift.protocol.TField("brightness", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new WireMultiSensorStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new WireMultiSensorTupleSchemeFactory();

  public int id; // required
  public int temperature; // required
  public int humidity; // required
  public int brightness; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    TEMPERATURE((short)2, "temperature"),
    HUMIDITY((short)3, "humidity"),
    BRIGHTNESS((short)4, "brightness");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // TEMPERATURE
          return TEMPERATURE;
        case 3: // HUMIDITY
          return HUMIDITY;
        case 4: // BRIGHTNESS
          return BRIGHTNESS;
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
    @org.apache.thrift.annotation.Nullable
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
  private static final int __ID_ISSET_ID = 0;
  private static final int __TEMPERATURE_ISSET_ID = 1;
  private static final int __HUMIDITY_ISSET_ID = 2;
  private static final int __BRIGHTNESS_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TEMPERATURE, new org.apache.thrift.meta_data.FieldMetaData("temperature", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.HUMIDITY, new org.apache.thrift.meta_data.FieldMetaData("humidity", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.BRIGHTNESS, new org.apache.thrift.meta_data.FieldMetaData("brightness", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WireMultiSensor.class, metaDataMap);
  }

  public WireMultiSensor() {
  }

  public WireMultiSensor(
    int id,
    int temperature,
    int humidity,
    int brightness)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.temperature = temperature;
    setTemperatureIsSet(true);
    this.humidity = humidity;
    setHumidityIsSet(true);
    this.brightness = brightness;
    setBrightnessIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WireMultiSensor(WireMultiSensor other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.temperature = other.temperature;
    this.humidity = other.humidity;
    this.brightness = other.brightness;
  }

  public WireMultiSensor deepCopy() {
    return new WireMultiSensor(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    setTemperatureIsSet(false);
    this.temperature = 0;
    setHumidityIsSet(false);
    this.humidity = 0;
    setBrightnessIsSet(false);
    this.brightness = 0;
  }

  public int getId() {
    return this.id;
  }

  public WireMultiSensor setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public int getTemperature() {
    return this.temperature;
  }

  public WireMultiSensor setTemperature(int temperature) {
    this.temperature = temperature;
    setTemperatureIsSet(true);
    return this;
  }

  public void unsetTemperature() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TEMPERATURE_ISSET_ID);
  }

  /** Returns true if field temperature is set (has been assigned a value) and false otherwise */
  public boolean isSetTemperature() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TEMPERATURE_ISSET_ID);
  }

  public void setTemperatureIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TEMPERATURE_ISSET_ID, value);
  }

  public int getHumidity() {
    return this.humidity;
  }

  public WireMultiSensor setHumidity(int humidity) {
    this.humidity = humidity;
    setHumidityIsSet(true);
    return this;
  }

  public void unsetHumidity() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __HUMIDITY_ISSET_ID);
  }

  /** Returns true if field humidity is set (has been assigned a value) and false otherwise */
  public boolean isSetHumidity() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __HUMIDITY_ISSET_ID);
  }

  public void setHumidityIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __HUMIDITY_ISSET_ID, value);
  }

  public int getBrightness() {
    return this.brightness;
  }

  public WireMultiSensor setBrightness(int brightness) {
    this.brightness = brightness;
    setBrightnessIsSet(true);
    return this;
  }

  public void unsetBrightness() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BRIGHTNESS_ISSET_ID);
  }

  /** Returns true if field brightness is set (has been assigned a value) and false otherwise */
  public boolean isSetBrightness() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BRIGHTNESS_ISSET_ID);
  }

  public void setBrightnessIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BRIGHTNESS_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case TEMPERATURE:
      if (value == null) {
        unsetTemperature();
      } else {
        setTemperature((Integer)value);
      }
      break;

    case HUMIDITY:
      if (value == null) {
        unsetHumidity();
      } else {
        setHumidity((Integer)value);
      }
      break;

    case BRIGHTNESS:
      if (value == null) {
        unsetBrightness();
      } else {
        setBrightness((Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case TEMPERATURE:
      return getTemperature();

    case HUMIDITY:
      return getHumidity();

    case BRIGHTNESS:
      return getBrightness();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case TEMPERATURE:
      return isSetTemperature();
    case HUMIDITY:
      return isSetHumidity();
    case BRIGHTNESS:
      return isSetBrightness();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that instanceof WireMultiSensor)
      return this.equals((WireMultiSensor)that);
    return false;
  }

  public boolean equals(WireMultiSensor that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_temperature = true;
    boolean that_present_temperature = true;
    if (this_present_temperature || that_present_temperature) {
      if (!(this_present_temperature && that_present_temperature))
        return false;
      if (this.temperature != that.temperature)
        return false;
    }

    boolean this_present_humidity = true;
    boolean that_present_humidity = true;
    if (this_present_humidity || that_present_humidity) {
      if (!(this_present_humidity && that_present_humidity))
        return false;
      if (this.humidity != that.humidity)
        return false;
    }

    boolean this_present_brightness = true;
    boolean that_present_brightness = true;
    if (this_present_brightness || that_present_brightness) {
      if (!(this_present_brightness && that_present_brightness))
        return false;
      if (this.brightness != that.brightness)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + id;

    hashCode = hashCode * 8191 + temperature;

    hashCode = hashCode * 8191 + humidity;

    hashCode = hashCode * 8191 + brightness;

    return hashCode;
  }

  @Override
  public int compareTo(WireMultiSensor other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.compare(isSetId(), other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.compare(isSetTemperature(), other.isSetTemperature());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTemperature()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.temperature, other.temperature);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.compare(isSetHumidity(), other.isSetHumidity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHumidity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.humidity, other.humidity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.compare(isSetBrightness(), other.isSetBrightness());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBrightness()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.brightness, other.brightness);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("WireMultiSensor(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("temperature:");
    sb.append(this.temperature);
    first = false;
    if (!first) sb.append(", ");
    sb.append("humidity:");
    sb.append(this.humidity);
    first = false;
    if (!first) sb.append(", ");
    sb.append("brightness:");
    sb.append(this.brightness);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WireMultiSensorStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public WireMultiSensorStandardScheme getScheme() {
      return new WireMultiSensorStandardScheme();
    }
  }

  private static class WireMultiSensorStandardScheme extends org.apache.thrift.scheme.StandardScheme<WireMultiSensor> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WireMultiSensor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TEMPERATURE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.temperature = iprot.readI32();
              struct.setTemperatureIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // HUMIDITY
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.humidity = iprot.readI32();
              struct.setHumidityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // BRIGHTNESS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.brightness = iprot.readI32();
              struct.setBrightnessIsSet(true);
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

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, WireMultiSensor struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TEMPERATURE_FIELD_DESC);
      oprot.writeI32(struct.temperature);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(HUMIDITY_FIELD_DESC);
      oprot.writeI32(struct.humidity);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(BRIGHTNESS_FIELD_DESC);
      oprot.writeI32(struct.brightness);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WireMultiSensorTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public WireMultiSensorTupleScheme getScheme() {
      return new WireMultiSensorTupleScheme();
    }
  }

  private static class WireMultiSensorTupleScheme extends org.apache.thrift.scheme.TupleScheme<WireMultiSensor> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WireMultiSensor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetTemperature()) {
        optionals.set(1);
      }
      if (struct.isSetHumidity()) {
        optionals.set(2);
      }
      if (struct.isSetBrightness()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetTemperature()) {
        oprot.writeI32(struct.temperature);
      }
      if (struct.isSetHumidity()) {
        oprot.writeI32(struct.humidity);
      }
      if (struct.isSetBrightness()) {
        oprot.writeI32(struct.brightness);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WireMultiSensor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.temperature = iprot.readI32();
        struct.setTemperatureIsSet(true);
      }
      if (incoming.get(2)) {
        struct.humidity = iprot.readI32();
        struct.setHumidityIsSet(true);
      }
      if (incoming.get(3)) {
        struct.brightness = iprot.readI32();
        struct.setBrightnessIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

