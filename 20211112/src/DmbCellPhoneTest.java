
public class DmbCellPhoneTest {

	public static void main(String[] args) {
		DmbCellPhone ex = new DmbCellPhone("�ڱ���", "����", 5);
		// �θ�Ŭ�����κ��� ��� ���� �޼��� ���
		ex.powerOn();
		ex.bell();
		ex.sendVoice("��������");
		ex.receiveVoice("ȫ�浿 �� �³���");
		ex.sendVoice("�ȳ��ϼ���");
		ex.hangUp();
		
		// �ڽ�Ŭ���� �޼��� ����
		ex.turnOnDmb();
		ex.changeChannelDmb(12);
		ex.turnOffDmb();
		
		
	}

}
