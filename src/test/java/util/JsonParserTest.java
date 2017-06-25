package util;


import static TestData.TestData.RESUME_1;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.model.Resume;
import com.model.Section;
import com.model.TextSection;
import com.util.JsonParser;
import org.junit.Assert;
import org.junit.Test;

public class JsonParserTest {
    @Test
    public void testResume() throws Exception {
        String json = JsonParser.write(RESUME_1);
        System.out.println(json);
        Resume resume = JsonParser.read(json, Resume.class);
        Assert.assertEquals(RESUME_1, resume);
    }

    @Test
    public void write() throws Exception {
        Section section1 = new TextSection("Objective1");
        String json = JsonParser.write(section1, Section.class);
        System.out.println(json);
        Section section2 = JsonParser.read(json, Section.class);
        Assert.assertEquals(section1, section2);
    }
}
