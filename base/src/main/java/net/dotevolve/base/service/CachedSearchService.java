package net.dotevolve.base.service;

import java.util.List;

import net.dotevolve.base.data.BaseEntity;
import net.dotevolve.base.data.BaseEntityReq;
import net.dotevolve.base.utils.CacheService;
import net.dotevolve.base.utils.CodeHelp;

public class CachedSearchService<Data extends BaseEntity, SReq extends BaseEntityReq> {

    private final SearchService<Data, SReq> searchService;

    private final CacheService cacheService;

    public CachedSearchService(SearchService<Data, SReq> searchService, CacheService cacheService) {
        this.searchService = searchService;
        this.cacheService = cacheService;
    }

    public List<Data> search(SReq request) {
        if (cacheService.exists(CodeHelp.toJson(request), request.getClass().getSimpleName())) {
            return (List<Data>) cacheService.get(CodeHelp.toJson(request), request.getClass().getSimpleName());
        }
        List<Data> resp = searchService.search(request);
        cacheService.save(CodeHelp.toJson(request), resp, request.getClass().getSimpleName());
        return resp;
    }
}
