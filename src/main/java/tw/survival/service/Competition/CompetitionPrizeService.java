package tw.survival.service.Competition;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.CompetitionPrizeRepository;

@Service
@Transactional
public class CompetitionPrizeService {

	@Autowired
	private CompetitionPrizeRepository cpDao;
}