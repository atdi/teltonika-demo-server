package eu.aagsolutions.telematics.teltonika.server.socket.handlers

import eu.aagsolutions.telematics.codec.hexStringToByteArray
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import org.springframework.stereotype.Component

@Component
@ChannelHandler.Sharable
class BinaryEncoder : MessageToMessageEncoder<CharSequence>() {
    override fun encode(
        ctx: ChannelHandlerContext,
        msg: CharSequence,
        out: MutableList<Any>,
    ) {
        if (msg.isEmpty()) {
            return
        }

        val response = hexStringToByteArray(msg.toString())
        out.add(Unpooled.copiedBuffer(response))
    }
}
