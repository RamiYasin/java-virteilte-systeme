struct WireMultiSensor {
  1: i32 id,
  2: i32 temperature,
  3: i32 humidity,
  4: i32 brightness
}

service WireMultiSensorService {
  list<WireMultiSensor> findById(1: i32 id),
  list<WireMultiSensor> findAll(),
  bool insertWireMultiSensor(1: i32 id, 2: i32 temperature, 3: i32 humidity, 4: i32 brightness),
  bool deleteWireMultiSensor(1: i32 id),
  bool updateWireMultiSensor(1: i32 id, 2: i32 temperature, 3: i32 humidity, 4: i32 brightness),
  void RTT(1: string time)
}