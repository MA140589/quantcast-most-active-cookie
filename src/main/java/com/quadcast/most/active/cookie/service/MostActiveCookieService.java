package com.quadcast.most.active.cookie.service;

import com.quadcast.most.active.cookie.exception.LogParsingException;
import com.quadcast.most.active.cookie.model.CommandInput;

/** Interface for filtering the most active cookies */
public interface MostActiveCookieService {
  void filterMostActiveCookies(CommandInput commandInput) throws LogParsingException;
}
