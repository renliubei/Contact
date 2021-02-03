package com.buaa1921rlb.contact.entity.other;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class RestResp {

    private final Integer code;
    private final String msg;
    private final Object data;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public static final RestResp OK = new RestResp(HttpStatus.OK);
    public static final RestResp FAIL = new RestResp(HttpStatus.INTERNAL_SERVER_ERROR);

    public static RestResp ok(Object data) {
        return new RestResp(HttpStatus.OK, data);
    }

    public static RestResp fail(String message) {
        return new RestResp(HttpStatus.SERVICE_UNAVAILABLE, message);
    }

    public RestResp(Integer code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public RestResp(Integer code, String msg) {
        this(code, msg, null);
    }

    public RestResp(HttpStatus httpStatus) {
        this(httpStatus.value(), httpStatus.getReasonPhrase());
    }

    public RestResp(HttpStatus httpStatus, Object data) {
        this(httpStatus.value(), httpStatus.getReasonPhrase(), data);
    }
}
