package de.illilli.opendata.service.einwohnernachaltersgruppen.bo;

public class EinwohnerNachAltersgruppenStadtteil extends
		EinwohnerNachAltersgruppen {

	private int nr;
	private String stadtteil;

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getStadtteil() {
		return stadtteil;
	}

	public void setStadtteil(String stadtteil) {
		this.stadtteil = stadtteil;
	}

	@Override
	public String toString() {
		return "EinwohnerNachAltersgruppenStadtteil [nr=" + nr + ", stadtteil="
				+ stadtteil + ", getEinwohnerInsgesamt()="
				+ getEinwohnerInsgesamt() + ", getA0_2()=" + getA0_2()
				+ ", getA3_5()=" + getA3_5() + ", getA6_14()=" + getA6_14()
				+ ", getA15_17()=" + getA15_17() + ", getA18_20()="
				+ getA18_20() + ", getA21_34()=" + getA21_34()
				+ ", getA35_59()=" + getA35_59() + ", getA60_64()="
				+ getA60_64() + ", getA65_74()=" + getA65_74()
				+ ", getA75_79()=" + getA75_79() + ", getA80undAelter()="
				+ getA80undAelter() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nr;
		result = prime * result
				+ ((stadtteil == null) ? 0 : stadtteil.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EinwohnerNachAltersgruppenStadtteil other = (EinwohnerNachAltersgruppenStadtteil) obj;
		if (nr != other.nr)
			return false;
		if (stadtteil == null) {
			if (other.stadtteil != null)
				return false;
		} else if (!stadtteil.equals(other.stadtteil))
			return false;
		return true;
	}

}
