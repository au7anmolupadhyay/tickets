package ticket.booking.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;

public class TrainService {

    private static final String TRAIN_PATH = "src/main/java/ticket/booking/localDB/trains.json";

    private List<Train> trainList;
    private ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public TrainService() throws IOException {
        File trains = new File(TRAIN_PATH);
        trainList = OBJECT_MAPPER.readValue(trains,new TypeReference<List<Train>>() {
        });
    }


    public List<Train> getTrains(String source, String destination){
        return trainList.stream().filter(train -> validTrain(train, source, destination)).collect(Collectors.toList());
    }

    public Boolean validTrain(Train train, String source, String destination){
        List<String> stations = train.getStations();
        return stations.contains(source) && stations.contains(destination) &&
                stations.indexOf(source) < stations.indexOf(destination);
    }
}