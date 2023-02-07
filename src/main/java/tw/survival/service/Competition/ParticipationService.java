package tw.survival.service.Competition;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.ParticipationRepository;

@Service
@Transactional
public class ParticipationService {

	@Autowired
	private ParticipationRepository pDao;
}