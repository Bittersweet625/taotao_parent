package com.xidian.search.service;

import com.xidian.common.pojo.SearchResult;

public interface SearchService {

    SearchResult search(String queryString, int page, int rows) throws Exception;
}
