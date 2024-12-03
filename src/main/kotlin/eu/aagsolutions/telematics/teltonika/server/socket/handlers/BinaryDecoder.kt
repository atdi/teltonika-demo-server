package eu.aagsolutions.telematics.teltonika.server.socket.handlers

import eu.aagsolutions.telematics.codec.bytesToHex
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder
import org.springframework.stereotype.Component

@Component
@ChannelHandler.Sharable
class BinaryDecoder : MessageToMessageDecoder<ByteBuf>() {
    override fun decode(
        ctx: ChannelHandlerContext,
        msg: ByteBuf,
        out: MutableList<Any>,
    ) {
        val binaryMsg = ByteArray(msg.readableBytes())
        msg.readBytes(binaryMsg)
        out.add(bytesToHex(binaryMsg))
    }
}
