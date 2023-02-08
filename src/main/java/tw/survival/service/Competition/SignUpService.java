package tw.survival.service.Competition;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.SignUpRepository;

@Service
@Transactional
public class SignUpService {

	@Autowired
	private SignUpRepository signUpRepository;

}