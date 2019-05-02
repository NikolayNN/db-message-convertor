package by.db.convert.script.gelios.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storage0")
public class GMessage {

  @Id
  private Long id;

  @Column(name = "unit_type")
  private String unitType;

  @Column(name = "unit_id")
  private String unitId;

  @Column(name="time")
  private long time;

  @Column(name = "lat")
  private float lat;

  @Column(name = "lon")
  private float lon;

  @Column(name="speed")
  private int speed;

  @Column(name="course")
  private int course;

  @Column(name="height")
  private int height;

  @Column(name="sats")
  private int sats;

  @Column(name="params")
  private String params;

  @Override
  public String toString() {
    return "GMessage{" +
            "id=" + id +
            ", unitType='" + unitType + '\'' +
            ", unitId='" + unitId + '\'' +
            ", time=" + time +
            ", lat=" + lat +
            ", lon=" + lon +
            ", speed=" + speed +
            ", course=" + course +
            ", height=" + height +
            ", sats=" + sats +
            ", params='" + params + '\'' +
            '}';
  }
}

