package Api.SpeakerWyr;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api.SpeakerWyr.models.Host;
@Service
public class HostService {
	
	@Autowired
	HostRepository hostRepo;
	
	public Host addHost(Host host) {
		return hostRepo.save(host);
	}

	public List<Host> fetchHosts() {
		List<Host> hosts = (List<Host>) hostRepo.findAll();
		return hosts;
	}

	public Host fetchHost(long id) {
		Optional<Host> retrievedHost = hostRepo.findById(id);
		return retrievedHost.get();
	}

	public void removeHost(Host host) {
		hostRepo.delete(host);
		
	}


}
