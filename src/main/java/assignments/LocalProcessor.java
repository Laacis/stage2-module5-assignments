package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private String processorVersion;
    private Scanner informationscanner;
    private List<String> stringArrayList;

    public LocalProcessor(String processorName, String processorVersion, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.processorVersion = processorVersion;
        this.stringArrayList = stringArrayList;
    }

    @ListIteratorAnnotation
    public void writeStringListHashes(LinkedList<String> stringList) {
        for (String string : stringList){
            System.out.println(string.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateFullProcessorName(LinkedList<String> names) {
        StringBuilder builder = new StringBuilder();
        builder.append(processorName);
        for(String name : names){
            builder.append(' ');
            builder.append(name);
        }
        return builder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public String readFullProcessorName(File file) {
        StringBuilder builder = new StringBuilder();
        builder.append(processorVersion);
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                builder.append( scanner.nextLine());
            }
        } catch (FileNotFoundException e){
            e.getMessage();
        }
        return builder.toString();
    }
}
