package com.w27.linktracker.repository;

import com.w27.linktracker.model.Link;

public interface ILinkTrackerRepository {
    public Integer create (Link link); //1. Crear un link
    public Link getMetrics (Integer linkId);//3.Cantidad de veces que se redireccionó un link
    public Link invalidate (Link link);//4. Invalidar un link
}
