package com.sales.management.BaseResponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class APIResponse<T> {

    int recordCount;
    T response;
}