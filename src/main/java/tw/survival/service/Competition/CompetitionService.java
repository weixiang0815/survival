package tw.survival.service.Competition;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.CompetitionRepository;

@Service
@Transactional
public class CompetitionService {

	@Autowired
	private CompetitionRepository competitionRepository;

}