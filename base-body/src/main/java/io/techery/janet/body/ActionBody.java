package io.techery.janet.body;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class ActionBody {

    public static final String MIMETYPE_UNKNOWN = "application/unknown";

    private final String mimeType;

    public ActionBody(String mimeType) {
        if (mimeType == null) {
            mimeType = MIMETYPE_UNKNOWN;
        }
        this.mimeType = mimeType;
    }

    public final String mimeType() {
        return mimeType;
    }

    public abstract long length();

    public abstract InputStream getContent() throws IOException;

    public abstract void writeContentTo(OutputStream os) throws IOException;

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionBody that = (ActionBody) o;

        return mimeType != null ? mimeType.equals(that.mimeType) : that.mimeType == null;
    }

    @Override public int hashCode() {
        return mimeType != null ? mimeType.hashCode() : 0;
    }

    @Override public String toString() {
        return "ActionBody{" +
                "mimeType='" + mimeType + '\'' +
                '}';
    }

}
