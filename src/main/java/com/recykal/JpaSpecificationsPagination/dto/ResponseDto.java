package com.recykal.JpaSpecificationsPagination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T>
{
    int recordCount;
    T response;
}
