package com.img.tennistournament.utils;

import com.img.tennistournament.models.Match;

public class CommonUtil {

  public static Match[] getMatches(String filename) {
    return (Match[]) ResourceFileLoaderUtils.loadResourceFile(filename, Match[].class);
  }

}
