package com.nari.boxcontrol;

/**
 * Created by zhenxin on 6/16/16.
 */
public abstract class DataProcessor {
    public int transToJOSN() {

        return 0;
    }

    public int processDataPacket(byte[] raw_data) {
        String start_mark = null;
        String dend_mark = null;
        int json_data_length = 0;
        int raw_data_length = raw_data.length;

        json_data_length = ((raw_data[1] & 0x000000ff) << 8) + (raw_data[2] & 0x000000ff);

        if ((raw_data[0] & 0x000000ff) == (0x68 & 0x000000ff)) {
            for (int i = 0; i < raw_data_length; i++) {
                if ((raw_data[i] & 0x000000ff) == (0x16 & 0x000000ff)) {
                    break;
                }

            }

        }
    return 0;
    }


}

