package io.reactiverse.pgclient.impl;

import io.reactiverse.pgclient.copy.CopyFormat;
import io.reactiverse.pgclient.PgException;
import io.reactiverse.pgclient.impl.codec.decoder.ErrorResponse;
import io.reactiverse.pgclient.impl.codec.encoder.MessageEncoder;
import io.reactiverse.pgclient.impl.codec.encoder.Query;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

class CopyInCommand extends CommandBase<Boolean> {

  private static String columns(List<String> columns) {
    if (columns.size() == 0) {
      return "";
    }
    return columns.stream()
      .map(c -> "\"" + c + "\"")
      .collect(Collectors.joining(",", "(", ")"));
  }

  private final String sql;

  CopyInCommand(String table, List<String> columnNames, CopyFormat format) {
    this.sql = MessageFormat.format("COPY \"{0}\" {1} FROM STDIN WITH (FORMAT ''{2}'')", table,
      columns(columnNames),
      format.name().toLowerCase());
  }

  @Override
  void exec(MessageEncoder out) {
    out.writeQuery(new Query(sql));
  }

  @Override
  public void handleCopyIn() {
    completionHandler.handle(CommandResponse.success(true));
  }

  @Override
  public void handleErrorResponse(ErrorResponse errorResponse) {
    failure = new PgException(errorResponse);
  }
}
