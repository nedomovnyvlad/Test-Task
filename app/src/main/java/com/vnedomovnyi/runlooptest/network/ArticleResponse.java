package com.vnedomovnyi.runlooptest.network;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.Data;

@Data
@Root(name = "item", strict = false)
public class ArticleResponse {

    @Element(name = "title")
    String title;

    @Element(name = "description")
    String description;

}

