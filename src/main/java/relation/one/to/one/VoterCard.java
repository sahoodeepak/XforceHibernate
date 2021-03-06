package relation.one.to.one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="voter_card_one_to_one_bi")
public class VoterCard {

	@Id
	private int voter_id;

	@OneToOne(mappedBy = "voterCard")
	private User_OneToOneBidirectional user;

	public int getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(int voter_id) {
		this.voter_id = voter_id;
	}

	public User_OneToOneBidirectional getUser() {
		return user;
	}

	public void setUser(User_OneToOneBidirectional user) {
		this.user = user;
	}

}