package com.storage.serializer;

import com.model.*;
import com.storage.interfaces.StreamSerializer;
import com.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XMLStreamSerializer implements StreamSerializer {
    private XmlParser xmlParser;

    public XMLStreamSerializer() {
        this.xmlParser = new XmlParser(Resume.class, Organization.class, Link.class, OrganizationSection.class, ListSection.class, TextSection.class, Organization.Position.class);
    }

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marshall(r, writer);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return xmlParser.unmarshall(reader);
        }
    }
}
