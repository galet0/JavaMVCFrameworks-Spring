package com.residentevil.serviceImpl;

import com.residentevil.entities.Capital;
import com.residentevil.entities.Virus;
import com.residentevil.models.bindingModels.VirusBindingModel;
import com.residentevil.models.viewModels.CapitalView;
import com.residentevil.repository.VirusRepository;
import com.residentevil.service.CapitalService;
import com.residentevil.service.VirusService;
import com.residentevil.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

@Service
public class VirusServiceImpl implements VirusService {

    private final VirusRepository virusRepository;

    private final ModelParser modelParser;

    private final CapitalService capitalService;

    @Autowired
    public VirusServiceImpl(VirusRepository virusRepository, ModelParser modelParser, CapitalService capitalService) {
        this.virusRepository = virusRepository;
        this.modelParser = modelParser;
        this.capitalService = capitalService;
    }

    @Override
    public void create(VirusBindingModel virusBindingModel) {
        Virus virus = this.modelParser.convert(virusBindingModel, Virus.class);
        Set<CapitalView> capitalViews = this.capitalService.getAllByNameIn(virusBindingModel.getCapitals());
        Set<Capital> capitals = new HashSet<>();
        for (CapitalView capitalView : capitalViews) {
            Capital capital = this.modelParser.convert(capitalView, Capital.class);
            capitals.add(capital);
        }
        virus.setCapitals(capitals);
        this.virusRepository.saveAndFlush(virus);
    }


    @Transactional
    @Override
    public String getGeoData() {
        List<Virus> viruses = this.virusRepository.getAllViruses();
        StringBuilder geoJson = new StringBuilder();
        String header = "{\n" +
                "    \"type\": \"FeatureCollection\",\n" +
                "    \"features\": [\n";
        String footer = "]\n" +
                "}\n";
        geoJson.append(header);
        StringJoiner joiner = new StringJoiner(",");
        for (Virus virus : viruses) {
            String color = "#f00";
            int magnitude = 0;
            switch (virus.getMagnitude()){
                case LOW:
                    magnitude = 4;
                    break;
                case MEDIUM:
                    magnitude = 5;
                    break;
                case HIGH:
                    magnitude = 6;
                    break;
            }

            for (Capital capital : virus.getCapitals()) {
                String body = String.format("{\n" +
                        "        \"type\": \"Feature\",\n" +
                        "        \"properties\": {\n" +
                        "            \"mag\": %d,\n" +
                        "            \"color\": \"%s\"\n" +
                        "        },\n" +
                        "        \"geometry\": {\n" +
                        "            \"type\": \"Point\",\n" +
                        "            \"coordinates\": [\n" +
                        "                %f,\n" +
                        "                %f\n" +
                        "            ]\n" +
                        "        }\n" +
                        "    }\n", magnitude, color, capital.getLatitude(), capital.getLongitude());
                joiner.add(body);
            }
        }

        geoJson.append(joiner);
        geoJson.append(footer);

        return geoJson.toString();
    }
}
