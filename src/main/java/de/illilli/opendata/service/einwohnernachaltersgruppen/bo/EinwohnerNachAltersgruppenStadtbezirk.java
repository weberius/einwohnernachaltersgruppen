package de.illilli.opendata.service.einwohnernachaltersgruppen.bo;

public class EinwohnerNachAltersgruppenStadtbezirk extends
		EinwohnerNachAltersgruppen {

	private int nr;
	private String stadtbezirk;

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getStadtbezirk() {
		return stadtbezirk;
	}

	public void setStadtbezirk(String stadtbezirk) {
		this.stadtbezirk = stadtbezirk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nr;
		result = prime * result
				+ ((stadtbezirk == null) ? 0 : stadtbezirk.hashCode());
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
		EinwohnerNachAltersgruppenStadtbezirk other = (EinwohnerNachAltersgruppenStadtbezirk) obj;
		if (nr != other.nr)
			return false;
		if (stadtbezirk == null) {
			if (other.stadtbezirk != null)
				return false;
		} else if (!stadtbezirk.equals(other.stadtbezirk))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EinwohnerNachAltersgruppenStadtbezirk [nr=" + nr
				+ ", stadtbezirk=" + stadtbezirk + ", getEinwohnerInsgesamt()="
				+ getEinwohnerInsgesamt() + ", getA0_2()=" + getA0_2()
				+ ", getA3_5()=" + getA3_5() + ", getA6_14()=" + getA6_14()
				+ ", getA15_17()=" + getA15_17() + ", getA18_20()="
				+ getA18_20() + ", getA21_34()=" + getA21_34()
				+ ", getA35_59()=" + getA35_59() + ", getA60_64()="
				+ getA60_64() + ", getA65_74()=" + getA65_74()
				+ ", getA75_79()=" + getA75_79() + ", getA80undAelter()="
				+ getA80undAelter() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
