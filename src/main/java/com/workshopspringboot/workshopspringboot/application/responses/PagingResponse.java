package com.workshopspringboot.workshopspringboot.application.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PagingResponse<T> {

    private ResponsePageable page;

    /**
     * elements of page.
     */
    private List<T> data;
}

