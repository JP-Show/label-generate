package com.hardware;

import java.io.IOException;
import java.util.List;

import com.utils.DOS;

public class Socket {
  public static String getName() throws IOException {
    String socket = "unknown";
    List<String> resultDOSocket = DOS.exec(new String[] { "cmd.exe", "/c", "win-x86\\publish\\SocketInfo.exe" });
    socket = resultDOSocket.get(0);
    return socket;
  }
}
