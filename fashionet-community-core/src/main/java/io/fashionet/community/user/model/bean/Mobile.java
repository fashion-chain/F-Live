package io.fashionet.community.user.model.bean;

import io.fashionet.core.base.model.converter.StringObjectMapper;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

@Data
public class Mobile implements StringObjectMapper {
    public static final String MOBILE_SPLITTER = " ";

    private String districtNumber;
    private String mobileNumber;

    public Mobile(String districtNumber, String mobileNumber) {
        this.districtNumber = districtNumber;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toObjString() {
        return StringUtils.join(new String[]{districtNumber, mobileNumber}, MOBILE_SPLITTER);
    }

    public static Mobile parseFromString(String str) {
        String[] args = StringUtils.split(str, MOBILE_SPLITTER);
        return new Mobile(args[0], args[1]);
    }
}
