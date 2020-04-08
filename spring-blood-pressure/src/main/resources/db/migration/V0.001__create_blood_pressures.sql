CREATE SEQUENCE blood_pressure_id_seq
    INCREMENT BY 1
    MAXVALUE 99999999
    START WITH 1
    NO CYCLE
;

CREATE TABLE IF NOT EXISTS blood_pressures(
  id INT PRIMARY KEY NOT NULL DEFAULT nextval('blood_pressure_id_seq'::regclass)
  , systolic_blood_pressure INTEGER NOT NULL
  , diastolic_blood_pressure INTEGER NOT NULL
  , pulse INTEGER NOT NULL
  , measuring_date DATE NOT NULL
  , measuring_time_zone_type INTEGER NOT NULL
  , created_at TIMESTAMP NOT NULL
);

COMMENT ON TABLE blood_pressures IS '血圧履歴';
COMMENT ON COLUMN blood_pressures.id IS 'ID';
COMMENT ON COLUMN blood_pressures.systolic_blood_pressure IS '収縮期血圧';
COMMENT ON COLUMN blood_pressures.diastolic_blood_pressure IS '拡張期血圧';
COMMENT ON COLUMN blood_pressures.pulse IS '脈拍';
COMMENT ON COLUMN blood_pressures.measuring_date IS '測定日';
COMMENT ON COLUMN blood_pressures.measuring_time_zone_type IS '測定時間帯区分 朝:1,夕:2';
COMMENT ON COLUMN blood_pressures.created_at IS '作成日時';