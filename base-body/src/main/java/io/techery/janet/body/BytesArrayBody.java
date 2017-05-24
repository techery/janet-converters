package io.techery.janet.body;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class BytesArrayBody extends ActionBody {

    private final byte[] bytes;

    public BytesArrayBody(String mimeType, byte[] bytes) {
        super(mimeType);
        if (bytes == null) throw new IllegalArgumentException("byte[] is null");
        this.bytes = bytes;
    }

    @Override public long length() {
        return bytes.length;
    }

    @Override public InputStream getContent() {
        return new ByteArrayInputStream(bytes);
    }

    @Override public void writeContentTo(OutputStream os) throws IOException {
        os.write(bytes);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BytesArrayBody that = (BytesArrayBody) o;

        return Arrays.equals(bytes, that.bytes);
    }

    @Override public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(bytes);
        return result;
    }

    @Override public String toString() {
        return "BytesArrayBody{" +
                "bytes length=" + length() +
                "} " + super.toString();
    }
}
