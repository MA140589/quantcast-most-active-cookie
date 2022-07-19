package com.quadcast.most.active.cookie.executor;


import com.quadcast.most.active.cookie.exception.LogParsingException;
import com.quadcast.most.active.cookie.model.CommandInput;
import com.quadcast.most.active.cookie.service.MostActiveCookieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.quadcast.most.active.cookie.constant.ProcessStatus.PROGRAM_FAILED;
import static com.quadcast.most.active.cookie.constant.ProcessStatus.SUCCESS;
import static com.quadcast.most.active.cookie.utility.LogParser.parseCommandInput;

/** Implementation for the interface ProcessExecutor */
public class ProcessExecutorImpl implements ProcessExecutor {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProcessExecutorImpl.class);
  private MostActiveCookieService mostActiveCookieService;

  public ProcessExecutorImpl(MostActiveCookieService mostActiveCookieService) {
    this.mostActiveCookieService = mostActiveCookieService;
  }

  @Override
  public int executeProcess(String[] args) {
    try {
      CommandInput commandInput = parseCommandInput(args);
      mostActiveCookieService.filterMostActiveCookies(commandInput);
      return SUCCESS.getValue();
    } catch (LogParsingException | RuntimeException e) {
      LOGGER.error("Program failed!", e);
    }
    return PROGRAM_FAILED.getValue();
  }
}
