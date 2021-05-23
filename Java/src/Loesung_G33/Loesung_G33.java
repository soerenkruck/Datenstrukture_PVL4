package Loesung_G33;

import PVL.PVL4;

import java.util.ArrayList;
import java.util.List;

public class Loesung_G33 implements PVL4 {

    private char[] alphabet;
    private float[] probabilities;

    private List<byte[]> codeAlphabet;

    @Override
    public void set_alphabet(char[] alphabet, float[] probabilities) {

        this.alphabet = alphabet;
        this.probabilities = probabilities;

        int position = 0;

        List<Character> alphabetList = new ArrayList<>();
        List<Float> posibilitiesList = new ArrayList<>();

        for (char a: alphabet) {
            alphabetList.add(a);
        }
        for (float f: probabilities) {
            posibilitiesList.add(f);
        }

        List<Character> sortedAlphabet = new ArrayList<>();
        List<Float> sortedProbabiliets = new ArrayList<>();

        // Sortierung nach der relativen Häufigkeit. Kleinste Häufigkeit zuerst.
        while (alphabetList.size() > 0) {

            int smallest = 0;

            for (int i = 1; i < alphabetList.size(); i++) {
                if (posibilitiesList.get(i) < posibilitiesList.get(smallest)) {
                    smallest = i;
                } else if (posibilitiesList.get(i).equals(posibilitiesList.get(smallest))) {
                    if (alphabetList.get(i) < alphabetList.get(smallest)) {
                        smallest = i;
                    }
                }
            }

            sortedAlphabet.add(alphabetList.get(smallest));
            sortedProbabiliets.add(posibilitiesList.get(smallest));
            alphabetList.remove(smallest);
            posibilitiesList.remove(smallest);
        }
        //System.out.println(sortedAlphabet);


        // Erstellen des Baums
        Tree tree = new Tree();

        for (int i = sortedAlphabet.size(); i > 0; i--) {
            if (i < sortedProbabiliets.size()) {
                Node leftNode = new Node(sortedProbabiliets.get(i), (byte) 1);

                if (i < sortedAlphabet.size() - 1) {
                    leftNode.setBackNode(tree.nodes.get(i + 1).get(0));
                    tree.addNode(leftNode);

                    Node rightNode = new Node(sortedAlphabet.get(--i), (byte) 0);
                    rightNode.setBackNode(tree.nodes.get(i + 1).get(0));
                    tree.addNode(rightNode);
                } else {
                    tree.addNode(leftNode);
                }
            }
        }
    }

    @Override
    public List<List<String>> get_codes() {
        return null;
    }

    @Override
    public String encode(String plain_text) {
        return null;
    }

    @Override
    public String decode(String huffman_text) {
        return null;
    }
}
