package com.meli.linktracker.repository;

import com.meli.linktracker.entity.Link;

import java.util.StringJoiner;

public interface ILinkRepository {

    String createLink(Link link);
}
