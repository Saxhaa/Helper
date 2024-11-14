package fr.insa.soa;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="Missions")
public class MissionService {
    private List<Mission> missions = new ArrayList<>();
    private static int currentMissionId = 1;

    @WebMethod
    public String postDemande(@WebParam(name = "userId") int userId,
                              @WebParam(name = "description") String description,
                              @WebParam(name = "name") String name) {
        Mission mission = new Mission();
        mission.setMissionId(currentMissionId++);
        mission.setPersonInNeedId(userId);
        mission.setDescription(description);
        mission.setName(name);
        mission.setStatut(0);
        missions.add(mission);
        return "Demande postée avec succès.";
    }
}
