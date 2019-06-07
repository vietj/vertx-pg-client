package io.vertx.mysqlclient.impl.codec;

import io.netty.buffer.ByteBuf;
import io.vertx.mysqlclient.impl.command.PingCommand;
import io.vertx.mysqlclient.impl.protocol.CommandType;
import io.vertx.sqlclient.impl.command.CommandResponse;

class PingCommandCodec extends CommandCodec<Void, PingCommand> {
  PingCommandCodec(PingCommand cmd) {
    super(cmd);
  }

  @Override
  void encode(MySQLEncoder encoder) {
    super.encode(encoder);
    sendPingCommand();
  }

  @Override
  void decodePayload(ByteBuf payload, MySQLEncoder encoder, int payloadLength, int sequenceId) {
    // we don't care what the response payload is from the server
    completionHandler.handle(CommandResponse.success(null));
  }

  private void sendPingCommand() {
    ByteBuf packet = allocateBuffer();
    // encode packet header
    packet.writeMediumLE(1);
    packet.writeByte(sequenceId);

    // encode packet payload
    packet.writeByte(CommandType.COM_PING);

    sendPacket(packet, 1);
  }
}
