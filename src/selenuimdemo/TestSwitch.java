package selenuimdemo;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class TestSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char today='a';
		switch(today){
    	case 'һ':
        case '��':
        case '��':
            System.out.println("��ͳ԰���");
       //���today=һ,��ִ�С���ͳ԰��ӡ�����break�ͽ����ˣ�û��break���ͻ�һֱִ����ȥ��֪������break
        break;
        case '��':
        case '��':
        case '��':
            System.out.println("��ͳ�����");
        break;
        case '��':
            System.out.println("����ϯ�ײ�");
        default:
        	System.out.println("ûʲô");
	}
	}
}
