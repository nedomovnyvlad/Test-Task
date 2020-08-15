package com.vnedomovnyi.runlooptest.network;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

import lombok.Data;

@Data
@Root(name = "rss", strict = false)
public class NewsResponse {

    @ElementList(name = "item", inline = true)
    @Path("channel")
    List<ArticleResponse> articleList;

}
